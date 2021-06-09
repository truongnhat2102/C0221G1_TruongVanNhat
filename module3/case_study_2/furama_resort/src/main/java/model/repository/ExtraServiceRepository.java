package model.repository;

import model.repository.BaseRepository;
import model.bean.ExtraService;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExtraServiceRepository {

    BaseRepository baseRepository = new BaseRepository();

    public List<ExtraService> findByIdCustomer(int id){
        List<ExtraService> extraServices = new ArrayList<>();
        Connection connection = baseRepository.connectionDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from extra_service " +
                    "right join contract_detail on extra_service.id_extra_service = contract_detail.id_extra_service " +
                    "join contract on contract.id_contract = contract_detail.id_contract " +
                    "join customer on customer.id_customer = contract.id_customer " +
                    "where id_customer = ?;");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idExtraService = resultSet.getInt("id_extra_service");
                String nameService = resultSet.getString("name_extra_service");
                double costExtraService = resultSet.getDouble("price_extra_service");
                int unit = resultSet.getInt("unit_extra_service");
                String status = resultSet.getString("status");
                ExtraService extraService = new ExtraService(idExtraService,nameService,costExtraService, unit, status);
                extraServices.add(extraService);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return extraServices;
    }

    public List<ExtraService> findByAll(){
        List<ExtraService> extraServiceList = new ArrayList<>();
        Connection connection = baseRepository.connectionDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from extra_service;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idExtraService = resultSet.getInt("id_extra_service");
                String nameService = resultSet.getString("name_extra_service");
                double costExtraService = resultSet.getDouble("price_extra_service");
                int unit = resultSet.getInt("unit_extra_service");
                String status = resultSet.getString("status");
                ExtraService extraService = new ExtraService(idExtraService,nameService,costExtraService, unit, status);
                extraServiceList.add(extraService);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return extraServiceList;
    }

    public ExtraService findById(int id){
        ExtraService extraService = null;
        Connection connection = baseRepository.connectionDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from extra_service" +
                    " where extra_service.id_extra_service = ?;");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idExtraService = resultSet.getInt("id_extra_service");
                String nameService = resultSet.getString("name_extra_service");
                double costExtraService = resultSet.getDouble("price_extra_service");
                int unit = resultSet.getInt("unit_extra_service");
                String status = resultSet.getString("status");
                extraService = new ExtraService(idExtraService,nameService,costExtraService, unit, status);
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return extraService;
    }
}
