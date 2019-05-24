package Telas;



import com.jfoenix.controls.JFXButton;
import Alert.MessageAlert;
import Controladores.ControladorVistoria;
import Entidades.Strings;
import Entidades.Vistoria;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TTaxa extends Application {
	private AnchorPane pane;
	private String usuario;
	private Menu menu;
	private MenuItem menuItemVoltar;
	private MenuBar menuBar;
	private VBox vBox;
	private TextField txfCNPJ;
	private TextField txfFuncionamento;
	private TextField txfHabitese;
	private Label lbCNPJ;
	private Label lbFuncionamento;
	private Label lbHabitese;
	private JFXButton btnPagar;

	private TableView<Vistoria> tableView;

	public TTaxa(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public void start(Stage stage) throws Exception {

		pane = new AnchorPane();
		pane.setPrefSize(800, 600);
		Scene scene = new Scene(pane);

		// CRIANDO TEXT FIELD CNPJ

		txfCNPJ = new TextField();
		txfCNPJ.setLayoutX(100);
		txfCNPJ.setLayoutY(490);

		// CRIANDO LABEL CNPJ
		lbCNPJ = new Label(Strings.lbCnpj + ":");
		lbCNPJ.setLayoutX(71);
		lbCNPJ.setLayoutY(490);

		// CRIANDO TEXT FIELD funcionamento

		txfFuncionamento = new TextField();
		txfFuncionamento.setLayoutX(370);
		txfFuncionamento.setLayoutY(490);

		// CRIANDO LABEL FUNCIONAMENTO
		lbFuncionamento = new Label(Strings.funcionamento + ":");
		lbFuncionamento.setLayoutX(280);
		lbFuncionamento.setLayoutY(490);

		// CRIANDO TEXT FIELD HABITESE

		txfHabitese = new TextField();
		txfHabitese.setLayoutX(690);
		txfHabitese.setLayoutY(490);

		// CRIANDO LABEL Habitese
		lbHabitese = new Label(Strings.habitese + ":");
		lbHabitese.setLayoutX(630);
		lbHabitese.setLayoutY(490);

		// CRIANDO BUTTON PAGAR
		btnPagar = new JFXButton(Strings.btnPagar);
		btnPagar.setLayoutX(400);
		btnPagar.setLayoutY(550);
		btnPagar.setStyle(Strings.btnStyle);

		// ADICIONANDO MENU
		menu = new Menu(Strings.titleMenu);
		menuItemVoltar = new MenuItem(Strings.titleVoltar);

		menu.getItems().add(menuItemVoltar);
		menuBar = new MenuBar();

		menuBar.getMenus().add(menu);
		vBox = new VBox(1, menuBar);
		vBox.setPrefSize(900, 40);

		// Nome da coluna empresa

		tableView = new TableView<Vistoria>();

		TableColumn<Vistoria, String> nomeColunaEmpresa = new TableColumn<Vistoria, String>(Strings.lbNome);
		nomeColunaEmpresa.setMinWidth(150);
		nomeColunaEmpresa.setCellValueFactory(new PropertyValueFactory<Vistoria, String>(Strings.lbNome.toLowerCase()));

		// Nome da coluna CNPJ
		TableColumn<Vistoria, String> nomeColunaCNPJ = new TableColumn<>(Strings.lbCnpj);
		nomeColunaCNPJ.setMinWidth(150);
		nomeColunaCNPJ.setCellValueFactory(new PropertyValueFactory<Vistoria, String>(Strings.lbCnpj.toLowerCase()));

		// Nome da coluna STATUS
		TableColumn<Vistoria, String> nomeColunaSTATUS = new TableColumn<>(Strings.lbstatus);
		nomeColunaSTATUS.setMinWidth(50);
		nomeColunaSTATUS
				.setCellValueFactory(new PropertyValueFactory<Vistoria, String>(Strings.lbstatus.toLowerCase()));

		// Nome da coluna Habitese
		TableColumn<Vistoria, Double> nomeColunaHabitese = new TableColumn<>(Strings.habitese);
		nomeColunaHabitese.setMinWidth(30);
		nomeColunaHabitese.setCellValueFactory(new PropertyValueFactory<Vistoria, Double>(Strings.taxaHabitese));

		// Nome da coluna Funcionamento
		TableColumn<Vistoria, Double> nomeColunaFuncionamento = new TableColumn<>(Strings.funcionamento);
		nomeColunaFuncionamento.setMinWidth(100);
		nomeColunaFuncionamento
				.setCellValueFactory(new PropertyValueFactory<Vistoria, Double>(Strings.taxaFuncionamento));

		tableView.setItems(getEmpresa());

		tableView.getColumns().add(nomeColunaEmpresa);
		tableView.getColumns().add(nomeColunaCNPJ);
		tableView.getColumns().add(nomeColunaFuncionamento);
		tableView.getColumns().add(nomeColunaHabitese);
		tableView.getColumns().add(nomeColunaSTATUS);
		tableView.setLayoutX(150);
		tableView.setLayoutY(60);

		// AÇAÕ DO MENU ITEM

		acaoMenuItemVoltar(menuItemVoltar, stage);

		// ACAO DA SCENE COM TECLA DE ATALHO

		scene.setOnKeyReleased((KeyEvent t) -> {
			if (t.getCode() == KeyCode.ESCAPE) {
				voltar(stage);
			}
		});

		// DISABLE
		btnPagar.setDisable(true);
		txfCNPJ.setDisable(true);
		txfFuncionamento.setDisable(true);
		txfHabitese.setDisable(true);

		tableView.setOnMouseClicked(e -> setarDadosTextField(txfCNPJ, txfFuncionamento, txfHabitese, tableView));
		// AÇAÕ DO BOTTAO PAGAR
		acaoBotaoPagar(btnPagar, tableView);

		pane.getChildren().add(vBox);
		pane.getChildren().add(tableView);
		pane.getChildren().add(txfCNPJ);
		pane.getChildren().add(lbCNPJ);
		pane.getChildren().add(txfFuncionamento);
		pane.getChildren().add(lbFuncionamento);
		pane.getChildren().add(txfHabitese);
		pane.getChildren().add(lbHabitese);
		pane.getChildren().add(btnPagar);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

	private void acaoMenuItemVoltar(MenuItem menuItemVoltar, Stage stage) {
		menuItemVoltar.setOnAction(e -> voltar(stage));
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

	private ObservableList<Vistoria> getEmpresa() {

		ObservableList<Vistoria> vistoriaList = FXCollections.observableArrayList();
		ControladorVistoria auxControladorEmpresa = ControladorVistoria.getInstance();

		vistoriaList.addAll(auxControladorEmpresa.getVistoria());
		return vistoriaList;
	}

	private void acaoBotaoPagar(JFXButton btnPagar, TableView<Vistoria> tableview) {

		btnPagar.setOnKeyPressed((KeyEvent t) -> {
			if (t.getCode() == KeyCode.ENTER) {
				Vistoria itemSelecionado = tableview.getSelectionModel().getSelectedItem();
				tableview.getItems().remove(itemSelecionado);
				MessageAlert.mensagemRealizadoSucesso(Strings.mensagemVistoriaPaga);
				limparCampos();
			}
		});

		btnPagar.setOnAction(e -> {
			Vistoria itemSelecionado = tableview.getSelectionModel().getSelectedItem();
			itemSelecionado.pagarFuncionamento(Double.parseDouble(getTxfFuncionamento().getText()));
			itemSelecionado.pagarHabitese(Double.parseDouble(getTxfHabitese().getText()));
			tableview.getItems().remove(itemSelecionado);
			MessageAlert.mensagemRealizadoSucesso(Strings.mensagemVistoriaPaga);
			limparCampos();
		});
	}

	private void setarDadosTextField(TextField cnpj, TextField funcionamento, TextField habitese,
			TableView<Vistoria> tableView) {
		MessageAlert.mensagemRealizadoSucesso(Strings.mensagemItemSelecionado);
		cnpj.setText(tableView.getSelectionModel().getSelectedItem().getCnpj());
		funcionamento.setText(String.valueOf(tableView.getSelectionModel().getSelectedItem().getTaxaFuncionamento()));
		habitese.setText(String.valueOf(tableView.getSelectionModel().getSelectedItem().getTaxaHabitese()));
		getBtnPagar().setDisable(false);
	}

	public JFXButton getBtnPagar() {
		return btnPagar;
	}

	public TextField getTxfCNPJ() {
		return txfCNPJ;
	}

	public TextField getTxfFuncionamento() {
		return txfFuncionamento;
	}

	public TextField getTxfHabitese() {
		return txfHabitese;
	}

	private void limparCampos() {
		getTxfCNPJ().setText("");
		getTxfFuncionamento().setText("");
		getTxfHabitese().setText("");
	}
}
