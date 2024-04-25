package org.example;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

    /**
     * Читает данные о людях из CSV файла и создает список объектов Person на основе этих данных.
     *
     * @param file CSV файл, содержащий данные о людях
     * @return список объектов Person, созданных из данных CSV файла
     * @throws IOException если возникает ошибка ввода-вывода при чтении файла
     */
    public static List<Person> readPersonsFromCSV(File file) throws IOException {
        List<Person> persons = new ArrayList<>();
        CSVReader csvReader = null;

        try {
            // Получаем поток данных из ресурса CSV файла
            InputStream inputStream = Main.class.getResourceAsStream("/foreign_names.csv");
            if (inputStream == null) {
                throw new IOException("Ресурс не найден: foreign_names.csv");
            }

            // Создаем CSVReader для чтения CSV данных
            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
            csvReader = new CSVReaderBuilder(new InputStreamReader(inputStream)).withCSVParser(parser).build();

            // Считываем все данные из CSV файла
            List<String[]> allData = csvReader.readAll();

            // Форматтер для парсинга даты рождения из строки
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy").withLocale(Locale.getDefault());

            // Обрабатываем каждую строку данных из CSV файла
            for (int i = 1; i < allData.size(); i++) {
                String[] row = allData.get(i);
                int id = Integer.parseInt(row[0]);
                String name = row[1];
                char gender = row[2].charAt(0);
                Department dep = new Department(row[4]);
                double salary = Double.parseDouble(row[5]);
                LocalDate DOB = LocalDate.parse(row[3], formatter);

                // Создаем объект Person и добавляем его в список
                persons.add(new Person(id, name, gender, dep, salary, DOB));
            }

        } catch (CsvException e) {
            // Обрабатываем ошибку при чтении CSV файла
            throw new IOException("Ошибка при чтении CSV файла", e);
        } finally {
            // Закрываем CSVReader в блоке finally для освобождения ресурсов
            if (csvReader != null) {
                try {
                    csvReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return persons;
    }

    /**
     * Главный метод приложения, который читает данные из CSV файла и выводит информацию о людях.
     *
     * @param args аргументы командной строки (не используются в этом приложении)
     */
    public static void main(String[] args) {
        Main main = new Main();
        File file = new File("/foreign_names.csv");

        try {
            // Читаем данные о людях из CSV файла
            List<Person> persons = readPersonsFromCSV(file);

            // Выводим информацию о каждом человеке
            for (Person person : persons) {
                System.out.println(person);
            }
        } catch (IOException e) {
            // Обрабатываем ошибку при обработке CSV файла
            System.err.println("Ошибка при обработке CSV файла: " + e.getMessage());
        }
    }
}
