/*
 * iReport - Visual Designer for JasperReports.
 * Copyright (C) 2002 - 2009 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of iReport.
 *
 * iReport is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * iReport is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with iReport. If not, see <http://www.gnu.org/licenses/>.
 */
package com.jaspersoft.ireport.designer.connection.gui;

import com.jaspersoft.ireport.locale.I18n;
import com.jaspersoft.ireport.designer.IReportConnection;
import com.jaspersoft.ireport.designer.IReportConnectionEditor;
import com.jaspersoft.ireport.designer.IReportManager;
import com.jaspersoft.ireport.designer.connection.JRXlsDataSourceConnection;
import com.jaspersoft.ireport.designer.tools.FieldPatternDialog;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/**
 *
 * @author  gtoffoli
 */
public class XlsDataSourceConnectionEditor extends javax.swing.JPanel implements IReportConnectionEditor {
    
    private IReportConnection iReportConnection = null;
    private boolean init = false;
    
    /** Creates new form EJBQLConnectionEditor */
    public XlsDataSourceConnectionEditor() {
        initComponents();

        jTextFieldDateFormat.setText( new SimpleDateFormat().toPattern());
        jTextFieldNumberFormat.setText( new DecimalFormat().toPattern());

        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                jButtonDeleteParameter.setEnabled(jTable1.getSelectedRow() >= 0);
            }
        });

        jTable1.getColumnModel().getColumn(1).setCellRenderer(new TableExcelNumberCellRenderer());
        jTable1.getColumnModel().getColumn(1).setCellEditor(new ExcelColumnEditor());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanelXLS = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldFilename = new javax.swing.JTextField();
        jButtonFilename = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jButtonNewParameter = new javax.swing.JButton();
        jButtonDeleteParameter = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButtonGetColumns = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jCheckBoxDateFormat = new javax.swing.JCheckBox();
        jTextFieldDateFormat = new javax.swing.JTextField();
        jButtonDateFormat = new javax.swing.JButton();
        jCheckBoxNumberFormat = new javax.swing.JCheckBox();
        jTextFieldNumberFormat = new javax.swing.JTextField();
        jButtonNumberFormat = new javax.swing.JButton();
        jCheckBoxFirstRowAsHeader = new javax.swing.JCheckBox();

        setLayout(new java.awt.BorderLayout());

        jPanelXLS.setPreferredSize(new java.awt.Dimension(1, 30));
        jPanelXLS.setLayout(new java.awt.GridBagLayout());

        jLabel15.setText("Excel file");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        jPanelXLS.add(jLabel15, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        jPanelXLS.add(jTextFieldFilename, gridBagConstraints);

        jButtonFilename.setText("Browse");
        jButtonFilename.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jButtonFilename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilenameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 27;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        jPanelXLS.add(jButtonFilename, gridBagConstraints);

        jPanel11.setLayout(new java.awt.GridBagLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Column names"));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jPanel9.setPreferredSize(new java.awt.Dimension(71, 200));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        jButtonNewParameter.setText("Add");
        jButtonNewParameter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewParameterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
        jPanel9.add(jButtonNewParameter, gridBagConstraints);

        jButtonDeleteParameter.setText("Delete");
        jButtonDeleteParameter.setEnabled(false);
        jButtonDeleteParameter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteParameterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 5, 3);
        jPanel9.add(jButtonDeleteParameter, gridBagConstraints);

        jPanel10.setLayout(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.weighty = 1.0;
        jPanel9.add(jPanel10, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 4);
        jPanel8.add(jPanel9, gridBagConstraints);

        jButtonGetColumns.setText("Get columns name from the first row of the file");
        jButtonGetColumns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGetColumnsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 7, 3);
        jPanel8.add(jButtonGetColumns, gridBagConstraints);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Column Name", "Column Index"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
        jPanel8.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel11.add(jPanel8, gridBagConstraints);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Other"));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jCheckBoxDateFormat.setText("Use custom date format");
        jCheckBoxDateFormat.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBoxDateFormat.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jCheckBoxDateFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDateFormatActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        jPanel6.add(jCheckBoxDateFormat, gridBagConstraints);

        jTextFieldDateFormat.setEnabled(false);
        jTextFieldDateFormat.setPreferredSize(new java.awt.Dimension(100, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel6.add(jTextFieldDateFormat, gridBagConstraints);

        jButtonDateFormat.setText("Date format");
        jButtonDateFormat.setEnabled(false);
        jButtonDateFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDateFormatActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        jPanel6.add(jButtonDateFormat, gridBagConstraints);

        jCheckBoxNumberFormat.setText("Use custom number format");
        jCheckBoxNumberFormat.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBoxNumberFormat.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jCheckBoxNumberFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxNumberFormatActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        jPanel6.add(jCheckBoxNumberFormat, gridBagConstraints);

        jTextFieldNumberFormat.setEnabled(false);
        jTextFieldNumberFormat.setPreferredSize(new java.awt.Dimension(100, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel6.add(jTextFieldNumberFormat, gridBagConstraints);

        jButtonNumberFormat.setText("Number format");
        jButtonNumberFormat.setEnabled(false);
        jButtonNumberFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNumberFormatActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        jPanel6.add(jButtonNumberFormat, gridBagConstraints);

        jCheckBoxFirstRowAsHeader.setText("Skip the first line (the column names will be read from the first line)");
        jCheckBoxFirstRowAsHeader.setActionCommand("Skip the first line (column names will be read from the first line)");
        jCheckBoxFirstRowAsHeader.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBoxFirstRowAsHeader.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jCheckBoxFirstRowAsHeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxFirstRowAsHeaderActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        jPanel6.add(jCheckBoxFirstRowAsHeader, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel11.add(jPanel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelXLS.add(jPanel11, gridBagConstraints);

        add(jPanelXLS, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxNumberFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxNumberFormatActionPerformed
        jTextFieldNumberFormat.setEnabled( this.jCheckBoxNumberFormat.isSelected());
        jButtonNumberFormat.setEnabled(  this.jCheckBoxNumberFormat.isSelected() );

        if (!this.jCheckBoxNumberFormat.isSelected())
        {
            jTextFieldNumberFormat.setText( new DecimalFormat().toPattern());
        }
}//GEN-LAST:event_jCheckBoxNumberFormatActionPerformed

    private void jButtonNumberFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNumberFormatActionPerformed
        FieldPatternDialog fpd = new FieldPatternDialog((JDialog)SwingUtilities.getWindowAncestor(this), true);
            fpd.setOnlyNumbers(true);

            fpd.setVisible(true);
            if (fpd.getDialogResult() == JOptionPane.OK_OPTION)
            {
                jTextFieldNumberFormat.setText( fpd.getPattern() );
            }
}//GEN-LAST:event_jButtonNumberFormatActionPerformed

    private void jButtonFilenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilenameActionPerformed

	    javax.swing.JFileChooser jfc = new javax.swing.JFileChooser( IReportManager.getInstance().getCurrentDirectory());

	    jfc.setDialogTitle(I18n.getString("XlsDataSourceConnectionEditor.DialogTitle.SelectFile"));

	    jfc.addChoosableFileFilter( new javax.swing.filechooser.FileFilter() {
		    public boolean accept(java.io.File file) {
			    String filename = file.getName();
			    return (filename.toLowerCase().endsWith(".xls") || file.isDirectory()) ;
		    }
		    public String getDescription() {
			    return "Excel *.xls";
		    }
	    });

	    jfc.setMultiSelectionEnabled(false);
	    jfc.setDialogType( javax.swing.JFileChooser.OPEN_DIALOG);
	    if  (jfc.showOpenDialog( this) == javax.swing.JOptionPane.OK_OPTION) {
		    java.io.File file = jfc.getSelectedFile();
                    try {
                        jTextFieldFilename.setText( file.getAbsolutePath() );
                    } catch (Exception ex){}
	    }
    }//GEN-LAST:event_jButtonFilenameActionPerformed

    private void jButtonDateFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDateFormatActionPerformed
        FieldPatternDialog fpd = new FieldPatternDialog((JDialog)SwingUtilities.getWindowAncestor(this), true);
            fpd.setOnlyDate(true);

            fpd.setVisible(true);
            if (fpd.getDialogResult() == JOptionPane.OK_OPTION)
            {
                jTextFieldDateFormat.setText( fpd.getPattern() );
            }
    }//GEN-LAST:event_jButtonDateFormatActionPerformed

    private void jCheckBoxDateFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDateFormatActionPerformed
        jTextFieldDateFormat.setEnabled( this.jCheckBoxDateFormat.isSelected());
        jButtonDateFormat.setEnabled(  this.jCheckBoxDateFormat.isSelected() );

        if (!this.jCheckBoxDateFormat.isSelected())
        {
            jTextFieldDateFormat.setText( new SimpleDateFormat().toPattern());
        }
    }//GEN-LAST:event_jCheckBoxDateFormatActionPerformed

    private void jButtonNewParameterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewParameterActionPerformed

        DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();

        // find max index...
        int index = 0;
        for (int i=0; i< dtm.getRowCount(); ++i)
        {
            Integer ix = (Integer)jTable1.getValueAt(i, 1);
            if (index <= ix.intValue()) index++;
        }

        dtm.addRow(new Object[]{"COLUMN_" + index, new Integer(index)});

    }//GEN-LAST:event_jButtonNewParameterActionPerformed

    private void jButtonDeleteParameterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteParameterActionPerformed


        DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();

        while (jTable1.getSelectedRowCount() > 0)
        {
            dtm.removeRow(jTable1.getSelectedRow());
        }

    }//GEN-LAST:event_jButtonDeleteParameterActionPerformed

    private void jButtonGetColumnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGetColumnsActionPerformed
        try {

            if (jTextFieldFilename.getText().length() > 0)
            {
                Workbook workbook = Workbook.getWorkbook(new FileInputStream(new File(jTextFieldFilename.getText())));
                Sheet sheet = workbook.getSheet(0);

                DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
                dtm.setRowCount(0);

                for(int columnIndex = 0; columnIndex < sheet.getColumns(); columnIndex++)
                {
                    Cell cell = sheet.getCell(columnIndex, 0);
                    String columnName = cell.getContents();
                    if (columnName != null && columnName.trim().length() > 0)
                    {
                        dtm.addRow(new Object[]{columnName, new Integer(columnIndex)});
                    }
                }

                jTable1.updateUI();

                jCheckBoxFirstRowAsHeader.setSelected(true);
            }
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex.getMessage(), I18n.getString("XlsDataSourceConnectionEditor.Message.Exception"), JOptionPane.ERROR_MESSAGE); //"message.title.exception"
        }
    }//GEN-LAST:event_jButtonGetColumnsActionPerformed

    private void jCheckBoxFirstRowAsHeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxFirstRowAsHeaderActionPerformed
        
    }//GEN-LAST:event_jCheckBoxFirstRowAsHeaderActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButtonDateFormat;
    private javax.swing.JButton jButtonDeleteParameter;
    private javax.swing.JButton jButtonFilename;
    private javax.swing.JButton jButtonGetColumns;
    private javax.swing.JButton jButtonNewParameter;
    private javax.swing.JButton jButtonNumberFormat;
    private javax.swing.JCheckBox jCheckBoxDateFormat;
    private javax.swing.JCheckBox jCheckBoxFirstRowAsHeader;
    private javax.swing.JCheckBox jCheckBoxNumberFormat;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelXLS;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldDateFormat;
    private javax.swing.JTextField jTextFieldFilename;
    private javax.swing.JTextField jTextFieldNumberFormat;
    // End of variables declaration//GEN-END:variables
    
    
    public void setIReportConnection(IReportConnection c) {
        
        this.iReportConnection = c;
        if (iReportConnection instanceof JRXlsDataSourceConnection)
        {
            JRXlsDataSourceConnection con = (JRXlsDataSourceConnection)iReportConnection;
            this.jTextFieldFilename.setText( con.getFilename() );
            
            if (con.getCustomDateFormat().length() > 0)
            {
                this.jCheckBoxDateFormat.setSelected(true);
                this.jTextFieldDateFormat.setText(con.getCustomDateFormat());
                this.jTextFieldDateFormat.setEnabled(true);
                this.jButtonDateFormat.setEnabled(true);
            }

            if (con.getCustomNumberFormat().length() > 0)
            {
                this.jCheckBoxNumberFormat.setSelected(true);
                this.jTextFieldNumberFormat.setText(con.getCustomNumberFormat());
                this.jTextFieldNumberFormat.setEnabled(true);
                this.jButtonNumberFormat.setEnabled(true);
            }
            
            this.jCheckBoxFirstRowAsHeader.setSelected( con.isUseFirstRowAsHeader() );
            
            DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
            for (int i=0; i< con.getColumnNames().size(); ++i)
            {
                dtm.addRow(new Object[] {con.getColumnNames().get(i), con.getColumnIndexes().get(i) });
            }
            
            if (dtm.getRowCount() > 0)
            {
                jTable1.setRowSelectionInterval(0, 0);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public IReportConnection getIReportConnection() {
        
        IReportConnection irConn = new JRXlsDataSourceConnection();

        ((JRXlsDataSourceConnection)irConn).setFilename( this.jTextFieldFilename.getText().trim() );

        ((JRXlsDataSourceConnection)irConn).setCustomDateFormat( jCheckBoxDateFormat.isSelected() ?  jTextFieldDateFormat.getText() : "");
        ((JRXlsDataSourceConnection)irConn).setCustomNumberFormat( jCheckBoxNumberFormat.isSelected() ?  jTextFieldNumberFormat.getText() : "");
        ((JRXlsDataSourceConnection)irConn).setUseFirstRowAsHeader( jCheckBoxFirstRowAsHeader.isSelected() );

        List<String> columnsNames = new ArrayList<String>();
        List<Integer> columnsIndexes = new ArrayList<Integer>();
        DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
        for (int i=0; i< dtm.getRowCount(); ++i)
        {
            columnsNames.add( (String)jTable1.getValueAt(i, 0));
            columnsIndexes.add( (Integer)jTable1.getValueAt(i, 1));
        }

        ((JRXlsDataSourceConnection)irConn).setColumnNames( columnsNames );
        ((JRXlsDataSourceConnection)irConn).setColumnIndexes( columnsIndexes );

        if (columnsNames.size() == 0)
        {
            if (JOptionPane.showConfirmDialog(this,I18n.getString("XlsDataSourceConnectionEditor.Dialog.Confirm"),"",JOptionPane.INFORMATION_MESSAGE) != JOptionPane.OK_OPTION) //"messages.connectionDialog.notAllColumnsDefined"
            {
                return null;
            }
        }
            

        iReportConnection = irConn;
        return iReportConnection;
    }
    
}





