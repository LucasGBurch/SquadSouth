package com.easyvoteapi.controller;

import com.easyvoteapi.dto.ScheduleDto;
import com.easyvoteapi.dto.ScheduleRequestDto;
import com.easyvoteapi.dto.ScheduleStartRequestDto;
import com.easyvoteapi.dto.ScheduleUpdateRequestDto;
import com.easyvoteapi.service.ScheduleService;
import com.easyvoteapi.utils.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/schedules", produces = MediaType.APPLICATION_JSON_VALUE)
public class ScheduleController {

    private final ScheduleService service;

    @PostMapping("/{assemblyId}")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public ScheduleDto create(@PathVariable Long assemblyId, @Valid @RequestBody ScheduleRequestDto scheduleRequestDto) {
        return this.service.create(assemblyId, scheduleRequestDto);
    }

    @GetMapping("/{assemblyId}/{scheduleId}")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public ScheduleDto findById(@PathVariable Long assemblyId, @PathVariable Long scheduleId) {
        return this.service.findById(assemblyId, scheduleId);
    }

    @GetMapping("/assembly/{assemblyId}")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public List<ScheduleDto> findAll(@PathVariable Long assemblyId) {
        return this.service.findAll(assemblyId);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public ScheduleDto update(@PathVariable Long id, @RequestBody ScheduleUpdateRequestDto scheduleUpdateRequestDto) {
        return this.service.update(id, scheduleUpdateRequestDto);
    }

    @PatchMapping("/start/{id}")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Status patchStart(@PathVariable Long id, @RequestBody ScheduleStartRequestDto scheduleStartRequestDto) {
        return this.service.patchStart(id, scheduleStartRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}
