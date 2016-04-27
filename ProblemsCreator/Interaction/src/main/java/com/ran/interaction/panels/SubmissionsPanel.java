package com.ran.interaction.panels;

import com.ran.interaction.components.NotEditableTableModel;
import com.ran.interaction.observer.EmptyObserver;
import com.ran.interaction.observer.Observer;
import com.ran.interaction.observer.Publisher;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;

public class SubmissionsPanel extends JPanel implements Publisher {

    public static final String ADD = "add_submission";
    public static final String RESUBMIT = "resubmit_submission";
    public static final String DELETE = "delete_submission";
    public static final String UPDATE = "update_submissions";
    
    private static final String NUMBER = "Number";
    private static final String PROBLEM = "Problem";
    private static final String EVALUATION = "Evaluation type";
    private static final String COMPILATOR = "Compilator";
    private static final String VERDICT = "Verdict";
    private static final String DECISION_TIME = "Decision time";
    
    private static final Object[] TABLE_HEADERS = new Object[] {
        NUMBER, PROBLEM, EVALUATION, COMPILATOR, VERDICT, DECISION_TIME
    };
    
    public SubmissionsPanel() {
        initComponents();
        initCustomComponents();
        setTableContent(new Object[][] { });
        initObservers();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        tableSubmissions = new javax.swing.JTable();
        buttonAdd = new javax.swing.JButton();
        buttonResubmit = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();

        tableSubmissions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableSubmissions.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(tableSubmissions);

        buttonAdd.setText("Add");

        buttonResubmit.setText("Resubmit");

        buttonDelete.setText("Delete");

        buttonUpdate.setText("Update");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonResubmit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonUpdate)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAdd)
                    .addComponent(buttonResubmit)
                    .addComponent(buttonDelete)
                    .addComponent(buttonUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonResubmit;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tableSubmissions;
    // End of variables declaration//GEN-END:variables

    private Map<String, Observer> observers = new HashMap<>();
    
    private void initCustomComponents() {
        buttonAdd.addActionListener(event -> getObserver(ADD).notify(ADD, null));
        buttonResubmit.addActionListener(event -> getObserver(RESUBMIT).notify(RESUBMIT, null)); // Use parameter
        buttonDelete.addActionListener(event -> getObserver(DELETE).notify(DELETE, null)); // Use parameter
        buttonUpdate.addActionListener(event -> getObserver(UPDATE).notify(UPDATE, null));
    }
    
    @Override
    public List<String> getAvailableIds() {
        return Arrays.asList(ADD, RESUBMIT, DELETE, UPDATE);
    }
    
    @Override
    public void subscribe(String id, Observer observer) {
        observers.put(id, observer);
    }

    @Override
    public Observer getObserver(String id) {
        return observers.getOrDefault(id, EmptyObserver.getInstanse());
    }
    
    public final void setTableContent(Object[][] content) {
        tableSubmissions.setModel(new NotEditableTableModel(content, TABLE_HEADERS));
//        TableColumnModel columnModel = new DefaultTableColumnModel();
//        for (int width: TABLE_COLUMN_WIDTHS) {
//            columnModel.addColumn(new TableColumn(0, width));
//        }
//        tableSubmissions.setColumnModel(columnModel);
    }
    
}