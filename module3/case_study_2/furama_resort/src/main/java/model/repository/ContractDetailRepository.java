package model.repository;

import model.repository.BaseRepository;
import model.bean.ContractDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContractDetailRepository {
    BaseRepository baseRepository = new BaseRepository();

    public boolean add(ContractDetail contractDetail){
        Connection connection = baseRepository.connectionDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into contract_detail (id_contract, id_extra_service, amount_contract_detail) " +
                    "values(?,?,?);");
            preparedStatement.setInt(1,contractDetail.getContract().getIdContract());
            preparedStatement.setInt(2,contractDetail.getExtraService().getIdExtraService());
            preparedStatement.setInt(3,contractDetail.getQuantity());
            check = preparedStatement.executeUpdate()>0;
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }
}
