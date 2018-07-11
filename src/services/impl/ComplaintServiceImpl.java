package services.impl;

import dao.ComplaintDAO;
import dao.impl.ComplaintDAOImpl;
import entities.cards.Complaint;
import java.io.Serializable;
import java.sql.SQLException;
import services.ComplaintService;

public class ComplaintServiceImpl extends AbstractServiceImpl implements ComplaintService {
    private ComplaintDAO complaintDAO = ComplaintDAOImpl.getInstance();

    @Override
    public Complaint save(Complaint complaint) {
        try {
            startTransaction();
            complaintDAO.save(complaint);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return complaint;
    }

    @Override
    public Complaint get(Serializable id) {
        Complaint complaint = new Complaint();
        try {
            startTransaction();
            complaint = complaintDAO.get(id);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return complaint;
    }

    @Override
    public void update(Complaint complaint) {
        try {
            startTransaction();
            complaintDAO.update(complaint);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int delete(Serializable id) {
        int countRows = 0;
        try {
            startTransaction();
            countRows = complaintDAO.delete(id);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }
}
