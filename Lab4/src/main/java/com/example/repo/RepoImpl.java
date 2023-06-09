package com.example.repo;

import com.example.repo.entity.CalcResultEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.io.*;

@Repository
public class RepoImpl implements Repo {
    private final IdRepository idRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public RepoImpl(IdRepository idRepository,
                    ObjectMapper objectMapper) {
        this.idRepository = idRepository;
        this.objectMapper = objectMapper;
    }


    private static final String DIRECTORY_PATH = "/Users/ysmes/Downloads/results";

    public Integer saveCalcResult(CalcResultEntity entity) {
        Integer id = idRepository.getLastId();
        entity.setId(id);

        try {
            // Конвертувати об'єкт entity в JSON
            String json = objectMapper.writeValueAsString(entity);

            // Зберегти JSON у файл з ім'ям "{id}.json"
            saveJsonToFile(json, id);
        } catch (IOException e) {
            e.printStackTrace();
        }

        idRepository.saveLastId(id + 1); // Зберегти нове значення lastId

        return entity.getId();
    }

    private void saveJsonToFile(String json, Integer id) throws IOException {
        String filePath = getFilePath(id);
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(json);
        fileWriter.close();
    }

    private String getFilePath(Integer id) {
        return DIRECTORY_PATH + File.separator + id + ".json";
    }

    @Override
    public CalcResultEntity getResultById(Integer id) {
        try {
            File file = getFileById(id);
            if (!file.exists()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Result not found");
            }

            String json = readJsonFromFile(file);
            CalcResultEntity result = convertJsonToEntity(json);

            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private File getFileById(Integer id) {
        String filePath = getFilePath(id);
        return new File(filePath);
    }

    private String readJsonFromFile(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }

    private CalcResultEntity convertJsonToEntity(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, CalcResultEntity.class);
    }
}



