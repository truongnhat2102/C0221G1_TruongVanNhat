package nasa_picture.service;

import nasa_picture.model.Picture;

import java.util.List;

public interface IPictureService {
    void addInteractive(Picture picture);

    List<Picture> findAll();

    Picture findById(int id);

    void delete(int id);

    void edit(int id, Picture picture);
}
