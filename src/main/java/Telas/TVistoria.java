package Telas;

import com.jfoenix.controls.JFXButton;

import Alert.MessageAlert;
import Controladores.ControladorEmpresa;
import Entidades.Strings;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TVistoria extends Application {
	private String usuario;
	private String nome;
	private String cnpj;
	private Menu menu;
	private MenuItem menuItemVoltar;
	private MenuBar menuBar;
	private VBox vBox;
	private TextField txfNome;
	private TextField txfCnpj;
	private TextField txfRua;
	private TextField txfBairro;
	private TextField txfCidade;
	private TextField txfCep;
	private TextField txfNumero;
	private TextField txfAreaTotalEdificacao;
	private TextField txfAreaVistoriadaEdificacao;
	private TextArea txaMotivo;
	private Label lbNome;
	private Label lbCnpj;
	private Label lbRua;
	private Label lbBairro;
	private Label lbCidade;
	private Label lbCep;
	private Label lbNumero;
	private Label lbAreaTotalEdificacao;
	private Label lbAreaVistoriada;
	private Label lbMotivo;
	private JFXButton btnBuscarEmpresa;
	private JFXButton btnCadastrarVistoria;
	private RadioButton radioButtonDeferido;
	private RadioButton radioButtonIndeferido;
	private ToggleGroup radioGroup;
	private HBox hbox;

	public TVistoria(String usuario) {
		this.usuario = usuario;
	}

	public TVistoria(String usuario, String nome, String cnpj) {
		this.usuario = usuario;
		this.cnpj = cnpj;
		this.nome = nome;
	}

	@Override
	public void start(Stage stage) throws Exception {
		AnchorPane pane = new AnchorPane();
		Scene scene = new Scene(pane);
		pane.setPrefSize(700, 500);

		// ADICIONANDO MENU
		menu = new Menu("Menu");
		menuItemVoltar = new MenuItem("Voltar");

		menu.getItems().add(menuItemVoltar);
		menuBar = new MenuBar();

		menuBar.getMenus().add(menu);
		vBox = new VBox(1, menuBar);
		vBox.setPrefSize(700, 40);

		// Criando Textfield nome

		txfNome = new TextField();
		txfNome.setLayoutX(60);
		txfNome.setLayoutY(100);
		// txfNome.setDisable(true);
		// CRIANDO LABEL NOME
		lbNome = new Label(Strings.lbNome + ":");
		lbNome.setLayoutX(22);
		lbNome.setLayoutY(100);

		// Criando Textfield CNPJ
		txfCnpj = new TextField();
		txfCnpj.setLayoutX(260);
		txfCnpj.setLayoutY(100);

		// CRIANDO LABEL CNPJ
		lbCnpj = new Label(Strings.lbCnpj + ":");
		lbCnpj.setLayoutX(230);
		lbCnpj.setLayoutY(100);

		// CRIANDO BUTTON
		btnBuscarEmpresa = new JFXButton(Strings.btnBuscarEmpresa);
		btnBuscarEmpresa.setLayoutX(290);
		btnBuscarEmpresa.setLayoutY(400);
		btnBuscarEmpresa.setStyle(
				"-fx-padding: 0.7em 0.57em; -fx-font-size: 14px;-jfx-button-type: RAISED;-fx-background-color: rgb(155, 10, 7);-fx-pref-width: 150;-fx-text-fill: WHITE;");

		// Criando Textfield Rua

		txfRua = new TextField();
		txfRua.setLayoutX(520);
		txfRua.setLayoutY(130);

		// CRIANDO LABEL Rua
		lbRua = new Label(Strings.lbRua + ": ");
		lbRua.setLayoutX(480);
		lbRua.setLayoutY(130);

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

		// Criando Textfield Numero
		txfNumero = new TextField();
		txfNumero.setLayoutX(260); // 260
		txfNumero.setLayoutY(160);

		// CRIANDO LABEL Numero
		lbNumero = new Label(Strings.lbNumero + ":");
		lbNumero.setLayoutX(210);// 230
		lbNumero.setLayoutY(160);

		// CRIANDO Textfield AreaTotalEdificacao
		txfAreaTotalEdificacao = new TextField();
		txfAreaTotalEdificacao.setLayoutX(146);
		txfAreaTotalEdificacao.setLayoutY(190);

		// CRIANDO LABEL AreaTotalEdificacao
		lbAreaTotalEdificacao = new Label(Strings.lbAreaTotalEdificacao + ":");
		lbAreaTotalEdificacao.setLayoutX(13);
		lbAreaTotalEdificacao.setLayoutY(190);

		// CRIANDO Textfield AreaVistoriada

		txfAreaVistoriadaEdificacao = new TextField();
		txfAreaVistoriadaEdificacao.setLayoutX(450);
		txfAreaVistoriadaEdificacao.setLayoutY(190);

		// CRIANDO Label AreaVistoriada
		lbAreaVistoriada = new Label(Strings.lbAreaVistoriada + ":");
		lbAreaVistoriada.setLayoutX(366);
		lbAreaVistoriada.setLayoutY(190);

		// CRIANDO Label Motivos
		lbMotivo = new Label(Strings.lbMotivo + ":");
		lbMotivo.setLayoutX(13);
		lbMotivo.setLayoutY(220);

		// CRIANDO TEXTAREA Motivos
		txaMotivo = new TextArea();
		txaMotivo.setPrefSize(260, 100);
		txaMotivo.setLayoutX(156);
		txaMotivo.setLayoutY(220);

		// CRIANDO BUTTON Cadastrar Vistoria
		btnCadastrarVistoria = new JFXButton(Strings.btnCadastrarVistoria);
		btnCadastrarVistoria.setLayoutX(100);
		btnCadastrarVistoria.setLayoutY(400);
		btnCadastrarVistoria.setStyle("-fx-padding: 0.7em 0.57em; -fx-font-size: 14px;-jfx-button-type: RAISED;-fx-background-color: rgb(155, 10, 7);-fx-pref-width: 150;-fx-text-fill: WHITE;");
		
		// SETANDO DISABLE NOS TEXTFIELDS
		txfNome.setDisable(true);
		txfCnpj.setDisable(true);
		txfNumero.setDisable(true);
		txfBairro.setDisable(true);
		txfCep.setDisable(true);
		txfCidade.setDisable(true);
		txfRua.setDisable(true);
		txaMotivo.setDisable(true);

		// CRIANDO GROUP DE RADIOBUTTONS
		radioButtonDeferido = new RadioButton(Strings.rdDeferido);
		radioButtonDeferido.setUserData(Strings.rdDeferido);

		radioButtonIndeferido = new RadioButton(Strings.rdIndeferido);
		radioButtonIndeferido.setUserData(Strings.rdIndeferido);

		radioGroup = new ToggleGroup();

		radioButtonDeferido.setToggleGroup(radioGroup);
		radioButtonIndeferido.setToggleGroup(radioGroup);

		hbox = new HBox();
		hbox.setLayoutX(190);
		hbox.setLayoutY(350);

		hbox.getChildren().add(radioButtonDeferido);
		hbox.getChildren().add(radioButtonIndeferido);

		radioGroup.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
					if (radioGroup.getSelectedToggle() != null) {
						if (radioGroup.getSelectedToggle().getUserData().equals(Strings.rdIndeferido)) {
							MessageAlert.mensagemRealizadoSucesso(Strings.mensagemMotivoIndeferimento);
							txaMotivo.setDisable(false);
						}

						if (radioGroup.getSelectedToggle().getUserData().equals(Strings.rdDeferido)) {
							txaMotivo.setDisable(true);
						}

					}
				});

		// SETANDO VALORES NOS TEXTFIELDS NOME E CNPJ
		if (!(this.cnpj == null && this.nome == null)) {
			txfNome.setText(nome);
			txfCnpj.setText(cnpj);
			buscarDadosEmpresa(nome);
		}
		// ACAO DA SCENE COM TECLA DE ATALHO
		scene.setOnKeyPressed((KeyEvent t) -> {
			if (t.getCode() == KeyCode.ESCAPE) {
				voltar(stage);
			}
		});

		// ACAO DO MENU ITEM
		acaoMenuItemVoltar(menuItemVoltar, stage);

		// ACAO DO BUTTON DE PESQUISAR EMPRESA
		acaoBotaoBuscar(btnBuscarEmpresa, stage);

		pane.getChildren().add(vBox);
		pane.getChildren().add(txfNome);
		pane.getChildren().add(txfCnpj);
		pane.getChildren().add(txfRua);
		pane.getChildren().add(txfBairro);
		pane.getChildren().add(lbBairro);
		pane.getChildren().add(txfCidade);
		pane.getChildren().add(lbCidade);
		pane.getChildren().add(txfCep);
		pane.getChildren().add(lbCep);
		pane.getChildren().add(txfNumero);
		pane.getChildren().add(lbNumero);
		pane.getChildren().add(lbRua);
		pane.getChildren().add(lbNome);
		pane.getChildren().add(lbCnpj);
		pane.getChildren().add(btnBuscarEmpresa);
		pane.getChildren().add(txfAreaTotalEdificacao);
		pane.getChildren().add(lbAreaTotalEdificacao);
		pane.getChildren().add(lbAreaVistoriada);
		pane.getChildren().add(txfAreaVistoriadaEdificacao);
		pane.getChildren().add(lbMotivo);
		pane.getChildren().add(txaMotivo);
		pane.getChildren().add(hbox);
		pane.getChildren().add(btnCadastrarVistoria);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
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

	private void acaoMenuItemVoltar(MenuItem menuItemVoltar, Stage stage) {
		menuItemVoltar.setOnAction(e -> voltar(stage));
	}

	private void acaoBotaoBuscar(JFXButton btnBuscarEmpresa, Stage stage) {
		btnBuscarEmpresa.setDefaultButton(false);
		btnBuscarEmpresa.setOnKeyPressed((KeyEvent t) -> {
			if (t.getCode() == KeyCode.ENTER) {
				telaPesquisaEmpresa(stage);
			}
		});

		btnBuscarEmpresa.setOnAction(e -> telaPesquisaEmpresa(stage));
	}

	private void telaPesquisaEmpresa(Stage stage) {

		ControladorEmpresa controladorEmpresa = ControladorEmpresa.getInstance();

		if (!(controladorEmpresa.getEmpresasCadastradas().size() == 0)) {

			try {
				new TPesquisaEmpresa(usuario).start(new Stage());
				stage.close();
			} catch (Exception e) {
				MessageAlert.mensagemErro(Strings.erroTela);
				e.printStackTrace();
			}
		} else {
			MessageAlert.mensagemErro(Strings.erroTela+"\n"+Strings.empresaNaoCadastrada);
		}
	}

	private void buscarDadosEmpresa(String nome) {

		ControladorEmpresa controladorEmpresa = ControladorEmpresa.getInstance();

		if (controladorEmpresa.buscarEmpresa(nome)) {
			int posicao = controladorEmpresa.getPosicao();
			System.out.println(controladorEmpresa.getPosicao());
			txfBairro.setText(controladorEmpresa.getEmpresasCadastradas().get(posicao).getEndereco().getBairro());
			txfCidade.setText(controladorEmpresa.getEmpresasCadastradas().get(posicao).getEndereco().getCidade());
			txfNumero.setText(controladorEmpresa.getEmpresasCadastradas().get(posicao).getEndereco().getNumero());
			txfRua.setText(controladorEmpresa.getEmpresasCadastradas().get(posicao).getEndereco().getRua());
			txfCep.setText(controladorEmpresa.getEmpresasCadastradas().get(posicao).getEndereco().getCep());
		} else {
			MessageAlert.mensagemErro(Strings.empresaNaoEncontrada);
		}
	}
}
