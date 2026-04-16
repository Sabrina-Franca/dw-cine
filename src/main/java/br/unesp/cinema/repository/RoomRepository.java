package br.unesp.cinema.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.unesp.cinema.model.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{
    
}