package nasa_picture.service.impl;

import nasa_picture.model.Picture;
import nasa_picture.repository.BaseRepository;
import nasa_picture.service.IPictureService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class PictureServiceImpl implements IPictureService {

    @Override
    public void addInteractive(Picture picture) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(picture);
        entityTransaction.commit();
    }

    @Override
    public List<Picture> findAll() {
        String queryStr = "SELECT c from picture as c";
        TypedQuery<Picture> query = BaseRepository.entityManager.createQuery(queryStr, Picture.class);
        return query.getResultList();
    }

    @Override
    public Picture findById(int id) {
        String queryStr = "select c from picture as c where c.id= :id";
        TypedQuery<Picture> query = BaseRepository.entityManager.createQuery(queryStr, Picture.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void edit(int id, Picture picture) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Picture picture1 = picture;
        picture1.setLikes(picture.getLikes()+1);
        BaseRepository.entityManager.merge(picture1);
        entityTransaction.commit();
    }
}
