package com.giang.service.impl;

import com.giang.repository.PictureRepository;
import com.giang.repository.entity.Picture;
import com.giang.service.PictureService;
import com.giang.service.dto.PictureDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public List<String> findAllPictureByPostId(Integer postId) {
        return pictureRepository.findImgByPostId(postId);
    }

    @Override
    public PictureDTO insertPicture(Integer postId, String imgLink) {
        Picture picture = pictureRepository.findByAndPostIdAndAndImgLink(postId, imgLink);
        if (Objects.nonNull(picture)) {
            throw new EntityExistsException("This link is exist for this post");
        }
        picture = new Picture();
        picture.setPostId(postId);
        picture.setImgLink(imgLink);
        picture = pictureRepository.saveAndFlush(picture);
        return (new ModelMapper()).map(picture, PictureDTO.class);
    }

    @Override
    public Boolean deletePicture(Integer id) {
        Picture picture = pictureRepository.findById(id);
        Optional.ofNullable(picture).orElseThrow(EntityNotFoundException::new);
        pictureRepository.delete(picture);
        return true;
    }
}
