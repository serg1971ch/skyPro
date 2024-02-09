package ru.shiba.toDoHiber.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.shiba.toDoHiber.model.Task;

import java.util.List;
import java.util.Optional;
@Repository
public class ToDoDaoImpl implements ToDoDao<Task>{

    private static final Logger log = LoggerFactory.getLogger(ToDoDaoImpl.class);

    @PersistenceContext
    private final EntityManager em;

    public ToDoDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void saveTask(Task task) {
        if (task.getId() <= 0) {
            log.info("сейчас будем сохранять: {}", task.getNameTask());
            em.persist(task);
            log.info("persisted girl: {}", task.getNameTask());
        } else {
            em.merge(task);
            log.info("merged girl: {}", task.getNameTask());
        }
    }

    @Override
    public List<Task> findAll() {
        return em.createQuery("select t from Task t ", Task.class)
                .getResultList();
    }

    @Override
    public List<Task> findByName(String name) {
        TypedQuery<Task> query = em.createQuery("select t " +
                        "from Task t " +
                        "where t.nameTask = :name",
                Task.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
//
    @Override
    public Optional<Task> findById(long id) {
        return Optional.ofNullable(em.find(Task.class, id));
    }

    @Override
    public void updateNameById(long id, String name) {
        Query query = em.createQuery("update Task t " +
                "set t.nameTask = :name " +
                "where t.id = :id");
        query.setParameter("name", name);
        query.setParameter("id", id);
        query.executeUpdate();
    }


//    @Override
//    public List<Girl> findAll() {
//        return em.createQuery("select g from Girl g", Girl.class)
//                .getResultList();
//    }

//    @Override
//    public List<Girl> findByName(String name) {
//        TypedQuery<Girl> query = em.createQuery("select g " +
//                        "from Girl g " +
//                        "where g.name = :name",
//                Girl.class);
//        query.setParameter("name", name);
//        return query.getResultList();
//    }

//    @Override
//    public Optional<Girl> findById(long id) {
//        return Optional.ofNullable(em.find(Girl.class, id));
//    }

//    @Override
//    public List<Girl> findByName(String name) {
//        TypedQuery<Girl> query = em.createQuery("select s " +
//                        "from OtusStudent s " +
//                        "where s.name = :name",
//                Girl.class);
//        query.setParameter("name", name);
//        return query.getResultList();
//    }

//    @Override
//    public void updateNameById(long id, String name) {
//        Query query = em.createQuery("update Girl g " +
//                "set g.name = :name " +
//                "where g.id = :id");
//        query.setParameter("name", name);
//        query.setParameter("id", id);
//        query.executeUpdate();
//    }

    @Override
    public void deleteById(long id) {
        Query query = em.createQuery("delete " +
                "from Task t " +
                "where t.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
