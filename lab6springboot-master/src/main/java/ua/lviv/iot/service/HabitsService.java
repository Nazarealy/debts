package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Habits;
import ua.lviv.iot.repository.HabitsRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class HabitsService {
    @Autowired
    HabitsRepository habitsRepository;

    public List<Habits> findAll() throws Exception{
        List<Habits> habits = new LinkedList<>(habitsRepository.findAll());
        if(habits.isEmpty()){
            return null;
        }
        return habits;
    }

    public Habits findById(Integer id) throws Exception{
        if(habitsRepository.findById(id).isPresent()){
            return habitsRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Habits entity) throws Exception{
        if(entity != null){
            habitsRepository.save(entity);
        }
    }

    @Transactional
    public void update(Habits entity) throws Exception{
        habitsRepository.findById(entity.getIdhabits()).map(oldEntity ->{
            oldEntity.setHabits(entity.getHabits());
            return habitsRepository.save(oldEntity);
        })
                .orElseGet(()-> habitsRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception{
        if(habitsRepository.findById(id).isPresent()){
            habitsRepository.deleteById(id);
        }
    }

}
