package model.repository;

import model.bean.Service;
import model.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    BaseRepository baseRepository = new BaseRepository();
    public List<Service> findByAll(){
        Connection connection = baseRepository.connectionDatabase();
        List<Service> serviceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from service " +
                    " join type_of_rent on service.id_type_rent = type_of_rent.id_type_rent " +
                    " join type_of_service on service.id_type_service = type_of_service.id_type_service;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id_service");
                String name = resultSet.getString("name_service");
                int area = resultSet.getInt("area_service");
                int floor = resultSet.getInt("floor_service");
                int maxPeople = resultSet.getInt("max_people_service");
                double cost = resultSet.getDouble("price_service");
                int idTypeRent = resultSet.getInt("id_type_rent");
                int idTypeService = resultSet.getInt("id_type_service");
                double poolArea = resultSet.getDouble("pool_area");
                String standardRoom = resultSet.getString("standard_room");
                String description = resultSet.getString("description");
                String nameTypeRent = resultSet.getString("name_type_rent");
                String nameTypeService = resultSet.getString("name_type_service");
                Service service = new Service(id,name,area,cost,maxPeople,idTypeService,nameTypeService,idTypeRent,nameTypeRent,standardRoom,description,poolArea,floor);
                serviceList.add(service);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceList;
    }

    public Service findById(int id){
        Connection connection = baseRepository.connectionDatabase();
        Service service = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from service " +
                    " join type_of_rent on type_of_rent.id_type_rent = service.id_type_rent " +
                    " join type_of_service on type_of_service.id_type_service = service.id_type_service " +
                    " where service.id_service = ?;");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name_service");
                int area = resultSet.getInt("area_service");
                int floor = resultSet.getInt("floor_service");
                int maxPeople = resultSet.getInt("max_people_service");
                double cost = resultSet.getDouble("price_service");
                int idTypeRent = resultSet.getInt("id_type_rent");
                int idTypeService = resultSet.getInt("id_type_service");
                double poolArea = resultSet.getDouble("pool_area");
                String standardRoom = resultSet.getString("standard_room");
                String description = resultSet.getString("description");
                String nameTypeRent = resultSet.getString("name_type_rent");
                String nameTypeService = resultSet.getString("name_type_service");
                service = new Service(id,name,area,cost,maxPeople,idTypeService,nameTypeService,idTypeRent,nameTypeRent,standardRoom,description,poolArea,floor);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return service;
    }

    public boolean add(Service service){
        Connection connection = baseRepository.connectionDatabase();
        boolean check=false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into service (name_service, area_service, floor_service, max_people_service, price_service, id_type_rent, id_type_service, pool_area, standard_room, description)" +
                    " values(?,?,?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1,service.getName());
            preparedStatement.setInt(2,service.getArea());
            preparedStatement.setInt(3,service.getFloor());
            preparedStatement.setInt(4,service.getMaxPeople());
            preparedStatement.setDouble(5,service.getCost());
            preparedStatement.setInt(6,service.getIdTypeRent());
            preparedStatement.setInt(7,service.getIdTypeService());
            preparedStatement.setDouble(8,service.getPoolArea());
            preparedStatement.setString(9,service.getStandardRoom());
            preparedStatement.setString(10,service.getDescription());
            check=preparedStatement.executeUpdate()>0;
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }
}
