package com.sannikova.server.data;

import com.sannikova.shared.model.Record;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Record> bookList;
    private final String PATH = getClass().getResource("/").getPath() + "com\\sannikova\\server\\data\\database_file";

    public Database() {
        this.bookList = new ArrayList<>();
    }

    public void addNewRecord(Record record) {
        this.bookList.add(record);
    }

    public void removeRecord(int id) {
        Record record = null;

        for(int i = 0; i < bookList.size(); i++) {
            if(id == bookList.get(i).getBook().getId()) {
                record = bookList.get(i);
                break;
            }
        }

        bookList.remove(record);
    }

    public List<Record> getAll() {
        return this.bookList;
    }

    // Сохранить список в .json файл
    public void saveInJsonFile() {  //слишком сложно
        File file = new File(PATH);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());

        try {
            objectWriter.writeValue(file, this.bookList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Загрузить список из .json файла
    public void loadFromJsonFile() { //понятно сомнительно
        File file = new File(PATH);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            bookList = objectMapper.readValue(file, new TypeReference<List<Record>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}