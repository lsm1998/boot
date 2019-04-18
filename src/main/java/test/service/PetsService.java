package test.service;

import test.domain.Pets;

import java.util.List;

/**
 * @作者：刘时明
 * @时间：2019/1/13-11:48
 * @说明：
 */
public interface PetsService
{
    List<Pets> getSimplePetsAll();

    Pets getPetsById(Long id);
}
