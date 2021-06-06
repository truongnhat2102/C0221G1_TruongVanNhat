package extra_service.model.repository;

import extra_service.model.bean.ExtraService;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExtraServiceRepository {

    BaseRepository baseRepository = new BaseRepository();

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

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return extraService;
    }
}
