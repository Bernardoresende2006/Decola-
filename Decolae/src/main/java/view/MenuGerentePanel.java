
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuGerentePanel extends JPanel {

    private FrameTelas frameTelas;

    private final Color AZUL = new Color(0, 0, 170);
    private final Color CIANO = new Color(0, 255, 255);
    private final Color BRANCO = Color.WHITE;

    public MenuGerentePanel(FrameTelas frameTelas) {
        this.frameTelas = frameTelas;

        configurarTela();
    }

    private void configurarTela() {
        setLayout(new BorderLayout());
        setBackground(BRANCO);

        // Cabeçalho
        JPanel cabecalho = new JPanel(new BorderLayout());
        cabecalho.setBackground(AZUL);
        cabecalho.setPreferredSize(new Dimension(0, 100));
        cabecalho.setBorder(
            BorderFactory.createEmptyBorder(10, 25, 10, 25)
        );

        JLabel titulo = new JLabel("DECOLAÊ");
        titulo.setForeground(CIANO);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 38));

        JLabel subtitulo = new JLabel("PAINEL DO GERENTE");
        subtitulo.setForeground(BRANCO);
        subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 16));
        subtitulo.setHorizontalAlignment(SwingConstants.RIGHT);

        cabecalho.add(titulo, BorderLayout.WEST);
        cabecalho.add(subtitulo, BorderLayout.EAST);

        add(cabecalho, BorderLayout.NORTH);

        // Área central
        JPanel conteudo = new JPanel(new BorderLayout(10, 25));
        conteudo.setBackground(BRANCO);
        conteudo.setBorder(
            BorderFactory.createEmptyBorder(35, 45, 35, 45)
        );

        JLabel mensagem = new JLabel(
            "Bem-vindo à área de gerenciamento",
            SwingConstants.CENTER
        );
        mensagem.setFont(new Font("SansSerif", Font.BOLD, 24));
        mensagem.setForeground(AZUL);

        conteudo.add(mensagem, BorderLayout.NORTH);

        // Botões de funcionalidades
        JPanel painelBotoes = new JPanel(new GridLayout(2, 2, 20, 20));
        painelBotoes.setBackground(BRANCO);

        JButton voosBtn = criarBotao("Gerenciar Funcionários");
        JButton funcionariosBtn = criarBotao("Gerenciar Trajeto");
        JButton passagensBtn = criarBotao("Gerenciar Aeronaves");
        JButton relatoriosBtn = criarBotao("Navegar como cliente");

        painelBotoes.add(voosBtn);
        painelBotoes.add(funcionariosBtn);
        painelBotoes.add(passagensBtn);
        painelBotoes.add(relatoriosBtn);

        conteudo.add(painelBotoes, BorderLayout.CENTER);

        add(conteudo, BorderLayout.CENTER);

        // Rodapé
        JButton sairBtn = new JButton("Sair");
        sairBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        sairBtn.addActionListener(e ->
            frameTelas.trocarTela("loginPanel")
        );

        JPanel rodape = new JPanel();
        rodape.setBackground(BRANCO);
        rodape.setBorder(
            BorderFactory.createEmptyBorder(0, 0, 20, 0)
        );
        rodape.add(sairBtn);

        add(rodape, BorderLayout.SOUTH);
    }

    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);

        botao.setBackground(AZUL);
        botao.setForeground(BRANCO);
        botao.setFont(new Font("SansSerif", Font.BOLD, 16));
        botao.setFocusPainted(false);
        botao.setPreferredSize(new Dimension(250, 100));

        return botao;
    }
}
