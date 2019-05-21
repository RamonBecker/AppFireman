package Telas;


import com.jfoenix.controls.JFXButton;
import Alert.MessageAlert;
import Controladores.ControladorEmpresa;
import Entidades.Empresa;
import Entidades.Endereco;
import Entidades.Strings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TEmpresa extends Application {
	private String usuario;
	private TextField txfNome;
	private TextField txfCnpj;
	private TextField txfNomefantasia;
	private TextField txfTelefone;
	private TextField txfRua;
	private TextField txfBairro;
	private TextField txfCidade;
	private TextField txfCep;
	private TextField txfEstado;
	private TextField txfNumero;
	private Label lbNome;
	private Label lbCnpj;
	private Label lbNomeFantasia;
	private Label lbTelefone;
	private Label lbRua;
	private Label lbBairro;
	private Label lbCidade;
	private Label lbCep;
	private Label lbEstado;
	private Label lbNumero;
	private Label lbEmpresa;
	private JFXButton btnCadastrar;
	
	public TEmpresa(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public void start(Stage stage) throws Exception {
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(700, 400);
		Scene scene = new Scene(pane);

		// CRIANDO LABEL Empresa
		lbEmpresa = new Label(Strings.lbEmpresa);
		lbEmpresa.setStyle("-fx-font-size: 14px;");
		lbEmpresa.setLayoutX(250);
		lbEmpresa.setLayoutY(33);

		// Criando Textfield nome

		txfNome = new TextField();
		txfNome.setLayoutX(60);
		txfNome.setLayoutY(70);

		// CRIANDO LABEL NOME
		lbNome = new Label(Strings.lbNome + ":");
		lbNome.setLayoutX(22);
		lbNome.setLayoutY(70);

		// Criando Textfield CNPJ
		txfCnpj = new TextField();
		txfCnpj.setLayoutX(260);
		txfCnpj.setLayoutY(70);

		// CRIANDO LABEL CNPJ
		lbCnpj = new Label(Strings.lbCnpj + ":");
		lbCnpj.setLayoutX(230);
		lbCnpj.setLayoutY(70);

		// Criando Textfield nomeFantasia
		txfNomefantasia = new TextField();
		txfNomefantasia.setLayoutX(520);
		txfNomefantasia.setLayoutY(70);

		// CRIANDO LABEL Nome fantasia
		lbNomeFantasia = new Label(Strings.lbNomefantasia + ":");
		lbNomeFantasia.setLayoutX(430);
		lbNomeFantasia.setLayoutY(70);

		// Criando Textfield Telefone
		txfTelefone = new TextField();
		txfTelefone.setLayoutX(70);
		txfTelefone.setLayoutY(100);
		txfTelefone.setPrefWidth(138);

		// CRIANDO LABEL Telefone

		lbTelefone = new Label(Strings.lbTelefone + ": ");
		lbTelefone.setLayoutX(20);
		lbTelefone.setLayoutY(100);

		// Criando Textfield Rua

		txfRua = new TextField();
		txfRua.setLayoutX(260);
		txfRua.setLayoutY(100);

		// CRIANDO LABEL Rua
		lbRua = new Label(Strings.lbRua + ": ");
		lbRua.setLayoutX(230);
		lbRua.setLayoutY(100);

		// Criando Textfield Bairro
		txfBairro = new TextField();
		txfBairro.setLayoutX(520);
		txfBairro.setLayoutY(100);

		// CRIANDO LABEL Bairro
		lbBairro = new Label(Strings.lbBairro + ":");
		lbBairro.setLayoutX(480);
		lbBairro.setLayoutY(100);

		// Criando Textfield Cidade
		txfCidade = new TextField();
		txfCidade.setLayoutX(60);
		txfCidade.setLayoutY(130);

		// CRIANDO LABEL Cidade
		lbCidade = new Label(Strings.lbCidade + ":");
		lbCidade.setLayoutX(20);
		lbCidade.setLayoutY(130);

		// Criando Textfield CEP
		txfCep = new TextField();
		txfCep.setLayoutX(260);
		txfCep.setLayoutY(130);

		// CRIANDO LABEL CEP
		lbCep = new Label(Strings.lbCep + ":");
		lbCep.setLayoutX(230);
		lbCep.setLayoutY(130);

		// Criando Textfield Estado
		txfEstado = new TextField();
		txfEstado.setLayoutX(520);
		txfEstado.setLayoutY(130);

		// CRIANDO LABEL Estado
		lbEstado = new Label(Strings.lbEstado + ":");
		lbEstado.setLayoutX(480);
		lbEstado.setLayoutY(130);

		// Criando Textfield Numero
		txfNumero = new TextField();
		txfNumero.setLayoutX(60);
		txfNumero.setLayoutY(160);

		// CRIANDO LABEL Numero
		lbNumero = new Label(Strings.lbNumero + ":");
		lbNumero.setLayoutX(13);
		lbNumero.setLayoutY(160);

		// CRIANDO BUTTON CADASTRAR
		btnCadastrar = new JFXButton(Strings.btnCadastrar);
		btnCadastrar.setLayoutX(260);
		btnCadastrar.setLayoutY(220);

		btnCadastrar.setStyle("-fx-padding: 0.7em 0.57em;\r\n" + "    -fx-font-size: 14px;\r\n"
				+ "    -jfx-button-type: RAISED;\r\n" + "    -fx-background-color: rgb(155, 10, 7);\r\n"
				+ "    -fx-pref-width: 100;\r\n" + "    -fx-text-fill: WHITE;");

		// ADICIONANDO MENU
		Menu menu = new Menu("Menu");
		MenuItem menuItem1 = new MenuItem("Voltar");

		menu.getItems().add(menuItem1);
		MenuBar menuBar = new MenuBar();

		menuBar.getMenus().add(menu);
		VBox vb = new VBox(1, menuBar);
		vb.setPrefSize(700, 40);

		// AÇÃO DOS BOTÕES
		// AÇÃO DO BOTAO CADASTRAR

		btnCadastrar.setDefaultButton(true);
		btnCadastrar.setOnKeyPressed((KeyEvent t) -> {
			if (t.getCode() == KeyCode.ENTER) {
				cadastrarEmpresa(txfNome, txfCnpj, txfRua, txfBairro, txfCidade, txfEstado, txfCep, txfNumero,
						txfNomefantasia, txfTelefone);
			}
		});

		btnCadastrar.setOnAction(e -> cadastrarEmpresa(txfNome, txfCnpj, txfRua, txfBairro, txfCidade, txfEstado,
				txfCep, txfNumero, txfNomefantasia, txfTelefone));

		//AÇÃO DO BOTÃO MENU ITEM VOLTAR
		
		menuItem1.setOnAction(e -> voltar(stage));
		
		scene.setOnKeyPressed((KeyEvent t) ->{
		    if(t.getCode() == KeyCode.ESCAPE) {
		    	voltar(stage);
		    }
		});
		
		// ADICIONANDO COMPONENTE NA TELA
		pane.getChildren().add(txfNome);
		pane.getChildren().add(lbNome);
		pane.getChildren().add(txfCnpj);
		pane.getChildren().add(lbCnpj);
		pane.getChildren().add(txfNomefantasia);
		pane.getChildren().add(lbNomeFantasia);
		pane.getChildren().add(txfTelefone);
		pane.getChildren().add(lbTelefone);
		pane.getChildren().add(txfRua);
		pane.getChildren().add(lbRua);
		pane.getChildren().add(txfBairro);
		pane.getChildren().add(lbBairro);
		pane.getChildren().add(txfCidade);
		pane.getChildren().add(lbCidade);
		pane.getChildren().add(txfCep);
		pane.getChildren().add(lbCep);
		pane.getChildren().add(txfEstado);
		pane.getChildren().add(lbEstado);
		pane.getChildren().add(btnCadastrar);
		pane.getChildren().add(txfNumero);
		pane.getChildren().add(lbNumero);
		pane.getChildren().add(lbEmpresa);
		pane.getChildren().add(vb);

		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

	private void cadastrarEmpresa(TextField txfNome, TextField txfCnpj, TextField txfRua, TextField txfBairro,
			TextField txfCidade, TextField txfEstado, TextField txfCep, TextField txfNumero, TextField txfNomefantasia,
			TextField txfTelefone) {

		Endereco endereco = new Endereco(txfRua.getText(), txfBairro.getText(), txfCidade.getText(),
				txfEstado.getText(), txfCep.getText(), txfNumero.getText());

		Empresa empresa = null;
		
		try {
			empresa = new Empresa(txfNome.getText(), endereco,txfNomefantasia.getText(), txfCnpj.getText(), 
					txfTelefone.getText());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ControladorEmpresa.getInstance().cadastrarEmpresa(empresa);;
	
		txfRua.setText("");
		txfNome.setText("");
		txfBairro.setText("");
		txfCnpj.setText("");
		txfCidade.setText("");
		txfNomefantasia.setText("");
		txfTelefone.setText("");
		txfNumero.setText("");
		txfEstado.setText("");
		txfCep.setText("");
	}

	private void voltar(Stage stage) {
		try {
			new TPrincipal(usuario).start(new Stage());
			stage.close();
			MessageAlert.mensagemRealizadoSucesso(Strings.mensagemVoltarTelaPrincipal);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
