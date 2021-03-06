/*
 * MainPanel.java
 * 
 * Copyright(c) 2007-2016 by Yingzhi Tech
 * All Rights Reserved
 * 
 * Created at 2016-08-04 20:03:04
 */
package com.yz.rms.client.ui;

import java.awt.BorderLayout;
import com.nazca.ui.util.CardLayoutWrapper;
import com.yz.rms.client.ClientContext;
import com.yz.rms.client.agent.AuthAgent;
import com.yz.rms.client.listener.AgentListener;
import com.yz.rms.client.ui.expenseform.ExpenseFormMgmtPanel;
import com.yz.rms.client.ui.expenseform.ExpenseFormTabPanel;
import com.yz.rms.client.ui.project.ProjectMgmtTabPanel;
import com.yz.rms.client.ui.stat.ExpenseStatTabPanel;
import com.yz.rms.client.ui.team.TeamMgmtPanel;
import com.yz.rms.client.util.FakeDataFactory;
import com.yz.rms.client.util.USMSUserSyncTool;
import com.yz.rms.common.consts.ProjectConst;
import com.yz.rms.common.enums.ExpenseRoleEnum;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JToggleButton;

/**
 * 主面板
 *
 * @author Qiu Dongyue <qdy@yzhtech.com>
 */
public class MainPanel extends javax.swing.JPanel {

    private CardLayoutWrapper card = null;
    List<JToggleButton> list = new ArrayList();

    //项目管理
    private ProjectMgmtTabPanel projectMgmtTabPane = null;
    //团队管理
    private TeamMgmtPanel teamMgmtPanel = null;
    //报销单管理
    private ExpenseFormMgmtPanel expenseFormMgmtPanel = null;
    //我的报销单
    private ExpenseFormTabPanel expenseFormTabPane = null;
    //报销统计
    private ExpenseStatTabPanel expenseStatTabPanel = null;

    private AuthAgent authAgent = null;

    /**
     * Creates new form MainPanel
     */
    public MainPanel() {
        initComponents();
        card = new CardLayoutWrapper(this);
        initAgentAndLis();
        for (Component c : nNavToolBar1.getComponents()) {
            if (c instanceof JToggleButton) {
                list.add((JToggleButton) c);
            }
        }
        if (!ClientContext.getUser().hasRole(ProjectConst.USMS_MODULE_ID,
                ExpenseRoleEnum.CEO.name()) && !ClientContext.getUser().hasRole(
                        ProjectConst.USMS_MODULE_ID, ExpenseRoleEnum.HR.name())) {
            list.remove(projectMgmtBtn);
            projectMgmtBtn.setVisible(false);
        }
        if (!ClientContext.getUser().hasRole(ProjectConst.USMS_MODULE_ID,
                ExpenseRoleEnum.CEO.name()) && !ClientContext.getUser().hasRole(
                        ProjectConst.USMS_MODULE_ID, ExpenseRoleEnum.HR.name())) {
            list.remove(teamMgmtBtn);
            teamMgmtBtn.setVisible(false);
        }
        if (!ClientContext.getUser().hasRole(ProjectConst.USMS_MODULE_ID,
                ExpenseRoleEnum.CEO.name()) && !ClientContext.getUser().hasRole(
                        ProjectConst.USMS_MODULE_ID, ExpenseRoleEnum.HR.name())
                && !ClientContext.getUser().hasRole(ProjectConst.USMS_MODULE_ID,
                        ExpenseRoleEnum.PM.name())) {
            list.remove(statMgmtBtn);
            statMgmtBtn.setVisible(false);
        }

    }

    public void init() {
        if (FakeDataFactory.isFake()) {
            initUI();
            card.show(CardLayoutWrapper.CONTENT);
            waitPane.setIndeterminate(false);
        } else {
            authAgent.start();
        }
    }

    private void initUI() {
        //设置默认选中项
        list.get(0).doClick();
    }

    private void initAgentAndLis() {
        authAgent = new AuthAgent();
        authAgent.addListener(authListener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        contentPane = new javax.swing.JPanel();
        nNavToolBar1 = new com.nazca.ui.NNavToolBar();
        projectMgmtBtn = new javax.swing.JToggleButton();
        teamMgmtBtn = new javax.swing.JToggleButton();
        expenseMgmtBtn = new javax.swing.JToggleButton();
        statMgmtBtn = new javax.swing.JToggleButton();
        waitPane = new com.nazca.ui.NWaitingPanel();
        initFailPane = new javax.swing.JPanel();
        resetBtn = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));

        setLayout(new java.awt.CardLayout());

        contentPane.setLayout(new java.awt.BorderLayout());

        nNavToolBar1.setFloatable(false);
        nNavToolBar1.setRollover(true);

        buttonGroup1.add(projectMgmtBtn);
        projectMgmtBtn.setSelected(true);
        projectMgmtBtn.setText("项目管理");
        projectMgmtBtn.setFocusable(false);
        projectMgmtBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        projectMgmtBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectMgmtBtnActionPerformed(evt);
            }
        });
        nNavToolBar1.add(projectMgmtBtn);

        buttonGroup1.add(teamMgmtBtn);
        teamMgmtBtn.setText("团队管理");
        teamMgmtBtn.setFocusable(false);
        teamMgmtBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        teamMgmtBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamMgmtBtnActionPerformed(evt);
            }
        });
        nNavToolBar1.add(teamMgmtBtn);

        buttonGroup1.add(expenseMgmtBtn);
        expenseMgmtBtn.setText("报销单管理");
        expenseMgmtBtn.setFocusable(false);
        expenseMgmtBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        expenseMgmtBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expenseMgmtBtnActionPerformed(evt);
            }
        });
        nNavToolBar1.add(expenseMgmtBtn);

        buttonGroup1.add(statMgmtBtn);
        statMgmtBtn.setText("统计管理");
        statMgmtBtn.setFocusable(false);
        statMgmtBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        statMgmtBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statMgmtBtnActionPerformed(evt);
            }
        });
        nNavToolBar1.add(statMgmtBtn);

        contentPane.add(nNavToolBar1, java.awt.BorderLayout.NORTH);

        add(contentPane, "CONTENT");
        add(waitPane, "WAIT");

        resetBtn.setText("重新初始化");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout initFailPaneLayout = new javax.swing.GroupLayout(initFailPane);
        initFailPane.setLayout(initFailPaneLayout);
        initFailPaneLayout.setHorizontalGroup(
            initFailPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(initFailPaneLayout.createSequentialGroup()
                .addGroup(initFailPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(initFailPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(initFailPaneLayout.createSequentialGroup()
                        .addGap(385, 385, 385)
                        .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(initFailPaneLayout.createSequentialGroup()
                .addGap(398, 398, 398)
                .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(415, Short.MAX_VALUE))
        );
        initFailPaneLayout.setVerticalGroup(
            initFailPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(initFailPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filler3, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(initFailPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filler2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(initFailPaneLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(resetBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                    .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler4, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(initFailPane, "FAIL");
    }// </editor-fold>//GEN-END:initComponents

    private void teamMgmtBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamMgmtBtnActionPerformed
        contentPane.removeAll();
        contentPane.add(nNavToolBar1, BorderLayout.NORTH);
        if (teamMgmtPanel == null) {
            teamMgmtPanel = new TeamMgmtPanel();
            teamMgmtPanel.onInit();
        }
        contentPane.add(teamMgmtPanel, BorderLayout.CENTER);
        contentPane.validate();
        contentPane.repaint();
    }//GEN-LAST:event_teamMgmtBtnActionPerformed

    private void expenseMgmtBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expenseMgmtBtnActionPerformed
        contentPane.removeAll();
        contentPane.add(nNavToolBar1, BorderLayout.NORTH);
        if (ClientContext.getUser().hasRole(ProjectConst.USMS_MODULE_ID,
                ExpenseRoleEnum.CEO.name()) || ClientContext.getUser().hasRole(
                        ProjectConst.USMS_MODULE_ID, ExpenseRoleEnum.HR.name())
                || ClientContext.getUser().hasRole(ProjectConst.USMS_MODULE_ID,
                        ExpenseRoleEnum.PM.name())) {
            if (expenseFormMgmtPanel == null) {
                expenseFormMgmtPanel = new ExpenseFormMgmtPanel();
            }
            contentPane.add(expenseFormMgmtPanel, BorderLayout.CENTER);

        } else if (ClientContext.getUser().hasRole(ProjectConst.USMS_MODULE_ID,
                ExpenseRoleEnum.EMPLOYEE.name())) {
            if (expenseFormTabPane == null) {
                expenseFormTabPane = new ExpenseFormTabPanel();
            }
            contentPane.add(expenseFormTabPane, BorderLayout.CENTER);
        }
        contentPane.validate();
        contentPane.repaint();
    }//GEN-LAST:event_expenseMgmtBtnActionPerformed

    private void projectMgmtBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectMgmtBtnActionPerformed
        contentPane.removeAll();
        contentPane.add(nNavToolBar1, BorderLayout.NORTH);
        if (projectMgmtTabPane == null) {
            projectMgmtTabPane = new ProjectMgmtTabPanel();
            projectMgmtTabPane.onInit();
        }
        contentPane.add(projectMgmtTabPane, BorderLayout.CENTER);
        contentPane.validate();
        contentPane.repaint();
    }//GEN-LAST:event_projectMgmtBtnActionPerformed

    private void statMgmtBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statMgmtBtnActionPerformed
        contentPane.removeAll();
        contentPane.add(nNavToolBar1, BorderLayout.NORTH);
        if (expenseStatTabPanel == null) {
            expenseStatTabPanel = new ExpenseStatTabPanel();
        }
        expenseStatTabPanel.onInit();
//        expenseStatTabPanel.onClickFirstBtn();
        contentPane.add(expenseStatTabPanel, BorderLayout.CENTER);
        contentPane.validate();
        contentPane.repaint();
    }//GEN-LAST:event_statMgmtBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        init();
    }//GEN-LAST:event_resetBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel contentPane;
    private javax.swing.JToggleButton expenseMgmtBtn;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JPanel initFailPane;
    private com.nazca.ui.NNavToolBar nNavToolBar1;
    private javax.swing.JToggleButton projectMgmtBtn;
    private javax.swing.JButton resetBtn;
    private javax.swing.JToggleButton statMgmtBtn;
    private javax.swing.JToggleButton teamMgmtBtn;
    private com.nazca.ui.NWaitingPanel waitPane;
    // End of variables declaration//GEN-END:variables

    private AgentListener<Boolean> authListener = new AgentListener<Boolean>() {

        @Override
        public void onStarted(long seq) {
            waitPane.showWaitingMode("正在初始化请稍后...");
            waitPane.setIndeterminate(true);
            card.show(CardLayoutWrapper.WAIT);
        }

        @Override
        public void onSucceeded(Boolean result, long seq) {
            USMSUserSyncTool.getInstance().start();
            initUI();
            card.show(CardLayoutWrapper.CONTENT);
            waitPane.setIndeterminate(false);
        }

        @Override
        public void onFailed(String errMsg, int errCode, long seq) {
            card.show(CardLayoutWrapper.FAIL);
            waitPane.setIndeterminate(false);
        }
    };

}
