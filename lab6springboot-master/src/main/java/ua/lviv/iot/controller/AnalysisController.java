package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Analysis;
import ua.lviv.iot.service.AnalysisService;

import java.util.List;

@RestController
@RequestMapping("/hospitallab4db")
public class AnalysisController {
    @Autowired
    AnalysisService analysisService;

    @GetMapping("/analysis")
    public List<Analysis> findAll() throws Exception{
        return analysisService.findAll();
    }

    @GetMapping("/analysis/{id}")
    public Analysis findById(@PathVariable Integer id) throws Exception{
        return analysisService.findById(id);
    }

    @PostMapping("/analysis")
    public void create(@RequestBody Analysis entity) throws Exception{
        analysisService.create(entity);
    }

    @PutMapping("/analysis/{id}")
    public void update(@PathVariable Integer id,@RequestBody Analysis entity) throws Exception{
        entity.setIdanalysis(id);
        analysisService.update(entity);
    }

    @DeleteMapping("/analysis/{id}")
    public void delete(@PathVariable Integer id) throws Exception{
        analysisService.delete(id);
    }
}
