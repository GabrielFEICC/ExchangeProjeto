
package controller;

import DAO.CriptoDAO;
import java.util.Random;
import javax.swing.JOptionPane;
import model.Moeda;
import view.JanelaCotacoes;

public class ControllerCripto {
    private JanelaCotacoes view;
    private CriptoDAO criptoDAO;
    private Moeda btc;
    private Moeda eth;
    private Moeda xrp;

    public JanelaCotacoes getView() {
        return view;
    }

    public void setView(JanelaCotacoes view) {
        this.view = view;
    }

    public CriptoDAO getCriptoDAO() {
        return criptoDAO;
    }

    public void setCriptoDAO(CriptoDAO criptoDAO) {
        this.criptoDAO = criptoDAO;
    }

    public Moeda getBtc() {
        return btc;
    }

    public void setBtc(Moeda btc) {
        this.btc = btc;
    }

    public Moeda getEth() {
        return eth;
    }

    public void setEth(Moeda eth) {
        this.eth = eth;
    }

    public Moeda getXrp() {
        return xrp;
    }

    public void setXrp(Moeda xrp) {
        this.xrp = xrp;
    }
    
    

    public ControllerCripto(JanelaCotacoes view) {
        this.view = view;
        this.criptoDAO = new CriptoDAO();
        this.btc = criptoDAO.consultarCotacao("btc");
        this.eth = criptoDAO.consultarCotacao("eth");
        this.xrp = criptoDAO.consultarCotacao("xrp");
    }

    public void atualizarCotacoesAleatorias() {
        atualizarCotacao(btc);
        atualizarCotacao(eth);
        atualizarCotacao(xrp);
    }

    private void atualizarCotacao(Moeda criptoMoeda) {
        try {
            Random random = new Random();
            double variacao = (random.nextDouble() * 10) - 5;
            double novaCotacao = criptoMoeda.getCotacaoAtual() + criptoMoeda.getCotacaoAtual() * (variacao / 100);
            criptoMoeda.setCotacaoAtual(novaCotacao);
            criptoDAO.atualizarCotacao(criptoMoeda);
            JOptionPane.showMessageDialog(view, criptoMoeda.getNome() + " cotação atualizada para: " + String.format("%.2f", novaCotacao), "Atualização de Cotação", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Erro ao atualizar cotação: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
