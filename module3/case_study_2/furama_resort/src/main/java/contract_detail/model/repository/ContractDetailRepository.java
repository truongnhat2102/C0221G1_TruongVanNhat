package contract_detail.model.repository;

import contract.model.bean.Contract;
import contract.model.repository.ContractRepository;
import contract_detail.model.repository.BaseRepository;
import contract_detail.model.bean.ContractDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }
}
