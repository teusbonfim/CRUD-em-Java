package view;

import dao.ClienteDAO;
import model.Cliente;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaCliente extends JFrame {
    private JTextField idField;
    private JTextField nomeField;
    private JTextField emailField;
    private JButton adicionarButton;
    private JButton atualizarButton;
    private JButton removerButton;
    private JButton buscarButton;
    private JList<String> listaClientes;
    private DefaultListModel<String> listModel;
    private ClienteDAO dao;

    public TelaCliente() {
        setTitle("Cadastro de Clientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLayout(new FlowLayout());
        getContentPane().setBackground(new Color(26, 21, 31));

        dao = new ClienteDAO();

        idField = new JTextField(5);
        nomeField = new JTextField(20);
        emailField = new JTextField(20);

        adicionarButton = new JButton("Adicionar Cliente");
        atualizarButton = new JButton("Atualizar Cliente");
        removerButton = new JButton("Remover Cliente");
        buscarButton = new JButton("Buscar Cliente");

        listModel = new DefaultListModel<>();
        listaClientes = new JList<>(listModel);
        listaClientes.setVisibleRowCount(10);
        listaClientes.setFixedCellWidth(450);

        // Painel para campos
        JPanel painelCampos = new JPanel(new FlowLayout());
        painelCampos.setBackground(new Color(26, 21, 31));
        painelCampos.add(new JLabel("ID:")).setForeground(Color.WHITE);
        painelCampos.add(idField);
        painelCampos.add(buscarButton);
        painelCampos.add(new JLabel("Nome:")).setForeground(Color.WHITE);
        painelCampos.add(nomeField);
        painelCampos.add(new JLabel("Email:")).setForeground(Color.WHITE);
        painelCampos.add(emailField);

        // Painel para botões
        JPanel painelBotoes = new JPanel(new FlowLayout());
        painelBotoes.setBackground(new Color(26, 21, 31));
        painelBotoes.add(adicionarButton);
        painelBotoes.add(atualizarButton);
        painelBotoes.add(removerButton);

        add(painelCampos);
        add(painelBotoes);
        add(new JScrollPane(listaClientes));

        atualizarLista();

        adicionarButton.addActionListener(e -> {
            String nome = nomeField.getText().trim();
            String email = emailField.getText().trim();
            if (nome.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nome e Email são obrigatórios!");
                return;
            }
            Cliente cliente = new Cliente(0, nome, email);
            dao.adicionar(cliente);
            JOptionPane.showMessageDialog(null, "Cliente Adicionado!");
            limparCampos();
            atualizarLista();
        });

        atualizarButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                String nome = nomeField.getText().trim();
                String email = emailField.getText().trim();
                if (nome.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nome e Email são obrigatórios!");
                    return;
                }
                Cliente cliente = new Cliente(id, nome, email);
                dao.atualizar(cliente);
                JOptionPane.showMessageDialog(null, "Cliente Atualizado!");
                limparCampos();
                atualizarLista();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID inválido!");
            }
        });

        removerButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                int confirm = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do cliente com ID " + id + "?");
                if (confirm == JOptionPane.YES_OPTION) {
                    dao.remover(id);
                    JOptionPane.showMessageDialog(null, "Cliente Removido!");
                    limparCampos();
                    atualizarLista();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID inválido!");
            }
        });

        buscarButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                Cliente cliente = dao.buscarPorId(id);
                if (cliente != null) {
                    nomeField.setText(cliente.getNome());
                    emailField.setText(cliente.getEmail());
                    JOptionPane.showMessageDialog(null, "Cliente encontrado!");
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID inválido!");
            }
        });

        setVisible(true);
    }

    private void atualizarLista() {
        listModel.clear();
        List<Cliente> clientes = dao.listar();
        for (Cliente c : clientes) {
            listModel.addElement("ID: " + c.getId() + " | Nome: " + c.getNome() + " | Email: " + c.getEmail());
        }
    }

    private void limparCampos() {
        idField.setText("");
        nomeField.setText("");
        emailField.setText("");
    }

    public static void main(String[] args) {
        new TelaCliente();
    }
}
