package com.example.irfan.evstation.irfan.services;


import com.example.irfan.evstation.irfan.dao.EvStationDao;
import com.example.irfan.evstation.irfan.entities.EvStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class EvstationServiceImpl implements EvstationService{

    @Autowired
    private EvStationDao evStationDao;
    public EvstationServiceImpl() {

    }

    @Override
    public List<EvStation> getStations(int limit, String sortOrder, String sortByParam) {
        Sort sort = Sort.by(sortByParam).ascending();
        if (sortOrder.equalsIgnoreCase("desc")){
            sort = Sort.by(sortByParam).descending();
        }
        PageRequest p = PageRequest.of(0,limit,sort);
        return evStationDao.findAll(p).getContent();
    }

    @Override
    public Optional<EvStation> getStation(long id) {
        return evStationDao.findById(id);
    }

    @Override
    public EvStation updateStation(EvStation evStation, MultipartFile image, Long id) throws IOException {
        if(image != null ){
            evStation.setImage(this.imageConverter(image));
        }
        else{
            evStationDao.findById(id).ifPresent(ev ->{
                evStation.setImage(ev.getImage());
            });
        }
        return evStationDao.save(evStation);
    }

    @Override
    public void deleteStation(long id) {
        evStationDao.deleteById(id);
    }



    @Override
    public EvStation addStation(EvStation evStation,MultipartFile image) throws IOException {
        try{
            evStation.setImage(this.imageConverter(image));
        }catch (Exception e){
            e.printStackTrace();
        }
        return evStationDao.save(evStation);
    }

    public String imageConverter(MultipartFile image) throws IOException{
        String b64image = "";
        try{
            b64image =  Base64.getEncoder().encodeToString(image.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
        return b64image;
    }

}
