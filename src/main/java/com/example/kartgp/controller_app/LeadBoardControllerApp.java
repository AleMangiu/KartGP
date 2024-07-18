package com.example.kartgp.controller_app;

import com.example.kartgp.bean.LeadBoardBean;
import com.example.kartgp.dao.LeadBoardDao;
import com.example.kartgp.entity.LeadBoard;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeadBoardControllerApp {
    private LeadBoardControllerApp() {
        throw new IllegalStateException("Utility class");
    }
    public static List<LeadBoardBean> getLeadBoard() throws SQLException {
        LeadBoardDao leadBoardDao = new LeadBoardDao();
        var leadBoardsBean = new ArrayList<LeadBoardBean>();
        var leadBoards = leadBoardDao.getLeadboard();
        for (LeadBoard leadBoard : leadBoards) {
            leadBoardsBean.add(new LeadBoardBean(leadBoard.getDriverEntity(), leadBoard.getNumberRaceEntity(), leadBoard.getTotalPointEntity()));
        }
        return  leadBoardsBean;
    }
}
