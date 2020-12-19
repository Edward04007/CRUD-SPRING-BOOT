package com.audio.som.Service;
import com.audio.som.Model.ExibirModal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Database extends JpaRepository<ExibirModal, Integer>{
    
}