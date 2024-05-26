/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import DAO.ContaDAO;
import DAO.CriptoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Moeda;
import view.JanelaComprarCripto;
import view.JanelaSaldo;

public class ControllerCompraVenda {
private JanelaComprarCripto viewCompra;
    private JanelaSaldo viewSaldo;
    private CriptoDAO criptoDAO;
    private ContaDAO contaDAO;
    private Connection conexao;

    public ControllerCompraVenda(JanelaComprarCripto viewCompra, JanelaSaldo viewSaldo) throws SQLException {
        this.viewCompra = viewCompra;
        this.viewSaldo = viewSaldo;
        this.criptoDAO = new CriptoDAO();
        this.contaDAO = new ContaDAO(conexao);
        this.conexao = new Conexao().getConnection();
    }

    public void comprarCripto(String cpf, String nome, double quantidade) {
        try {
            Moeda cripto = criptoDAO.consultarCotacao(nome);
            double saldoAtual = contaDAO.consultarSaldo(cpf);
            double valorCompra = cripto.getCotacaoAtual() * quantidade;

            if (saldoAtual >= valorCompra) {
                double novoSaldo = saldoAtual - valorCompra;
                contaDAO.atualizarSaldo(cpf, novoSaldo);
                criptoDAO.atualizarSaldoCripto(cpf, nome, quantidade);
                viewSaldo.exibirSaldoEth(); 
                viewSaldo.exibirSaldoBtc();
                viewSaldo.exibirSaldoXrp();
                JOptionPane.showMessageDialog(viewCompra, "Compra realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(viewCompra, "Saldo insuficiente!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(viewCompra, "Erro ao realizar a compra!", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    public double consultarSaldo(String cpf) throws SQLException {
        return contaDAO.consultarSaldo(cpf);
    }

    public double consultarQuantidadeCripto(String cpf, String nome) throws SQLException {
        return criptoDAO.consultarQuantidade(cpf, nome);
    }
    
    public void mostrarSaldoCripto(String cpf, String nome, double quantidade) {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            ContaDAO contaDAO = new ContaDAO(conn);
            CriptoDAO criptoDAO = new CriptoDAO();

            // Consultar os saldos
            double saldo = contaDAO.consultarSaldo(cpf);
            double saldoBtc = contaDAO.obterSaldoBtc(cpf);
            double saldoEth = contaDAO.obterSaldoEth(cpf);
            double saldoXrp = contaDAO.obterSaldoXrp(cpf);

            // Atualizar a exibição dos saldos na viewSaldo
            viewSaldo.setSaldo(saldo);
            viewSaldo.setSaldoBtc(saldoBtc);
            viewSaldo.setSaldoEth(saldoEth);
            viewSaldo.setSaldoXrp(saldoXrp);
            viewSaldo.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewSaldo, "Erro ao consultar saldo!", "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }


}
