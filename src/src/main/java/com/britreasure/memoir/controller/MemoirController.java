package com.britreasure.memoir.controller;

import com.britreasure.memoir.model.Memoir;
import com.britreasure.memoir.repository.MemoirRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author xcyxiner
 * @create: 2018-10-10 下午6:02
 */
@RestController
@RequestMapping("/api/memoir")
@Api("MemoirController API")
public class MemoirController {

    private MemoirRepository memoirRepository;

    @Autowired
    public MemoirController(MemoirRepository memoirRepository) {
        this.memoirRepository = memoirRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Memoir> getAllMemoir() {
        return memoirRepository.findAll();
    }


    @RequestMapping(method = RequestMethod.POST)
    public Memoir addMemoir(@RequestBody Memoir addMemoir) {
        return memoirRepository.insert(addMemoir);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Memoir getMemoir(@PathVariable String id) {
        Optional<Memoir> optional = memoirRepository.findById(id);
        if (optional.isPresent()) {
            Memoir deletedMemoir = optional.get();
            memoirRepository.delete(deletedMemoir);
            return deletedMemoir;
        }
        return new Memoir();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Memoir updateMemoir(@PathVariable String id, @RequestBody Memoir updatedMemoir) {
        Optional<Memoir> optional = memoirRepository.findById(id);
        if (optional.isPresent()) {
            updatedMemoir.setId(id);
            return memoirRepository.save(updatedMemoir);
        }
        return updatedMemoir;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Memoir removeMemoir(@PathVariable String id) {
        Optional<Memoir> optional = memoirRepository.findById(id);
        if (optional.isPresent()) {
            Memoir deletedMemoir = optional.get();
            memoirRepository.delete(deletedMemoir);
            return deletedMemoir;
        }
        return new Memoir();
    }

}
