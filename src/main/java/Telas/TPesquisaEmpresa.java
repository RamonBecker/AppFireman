package Telas;

import Controladores.ControladorEmpresa;
import Entidades.Empresa;
import Entidades.Strings;
import Entidades.TBVEmpresa;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TPesquisaEmpresa extends Application {
	private String usuario;
	private TableView<Empresa> tableView;
	private Label lbTituloPesquisa;
	private TextField txfNome;
	private TextField txfCNPJ;
	private Label lbNome;
	private Label lbCnpj;
	private Button btnSelecionar;
	private Menu menu;
	private MenuItem menuItemVoltar;
	private MenuBar menuBar;
	private VBox vBox;

	public TPesquisaEmpresa(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public void start(Stage stage) throws Exception {
		AnchorPane pane = new AnchorPane();
		Scene scene = new Scene(pane);
		pane.setPrefSize(700, 500);

		// Nome da coluna empresa
		TableColumn<Empresa, String> nomeColumnEmpresa = new TableColumn<>("Nome");
		nomeColumnEmpresa.setMinWidth(200);
		nomeColumnEmpresa.setCellValueFactory(new PropertyValueFactory<Empresa, String>("nome"));

		// Nome da coluna CNPJ
		TableColumn<Empresa, String> nomeColumnCNPJ = new TableColumn<>("CNPJ");
		nomeColumnCNPJ.setMinWidth(200);
		nomeColumnCNPJ.setCellValueFactory(new PropertyValueFactory<Empresa, String>("cnpj"));

		tableView = new TableView<Empresa>();
		tableView.setItems(getEmpresa());
		tableView.getColumns().add(nomeColumnEmpresa);
		tableView.getColumns().add(nomeColumnCNPJ);
		tableView.setLayoutY(60);

		// CRIANDO LABEL
		lbTituloPesquisa = new Label(Strings.tituloPesquisaEmpresa);
		lbTituloPesquisa.setLayoutX(250);
		lbTituloPesquisa.setLayoutY(35);
		lbTituloPesquisa.setStyle("-fx-font: 16px Arial;");

		// ADICIONANDO MENU
		menu = new Menu("Menu");
		menuItemVoltar = new MenuItem("Voltar");

		menu.getItems().add(menuItemVoltar);
		menuBar = new MenuBar();

		menuBar.getMenus().add(menu);
		vBox = new VBox(1, menuBar);
		vBox.setPrefSize(700, 40);

		// CRIANDO TEXT FIELD NOME
		txfNome = new TextField();
		txfNome.setLayoutX(550);
		txfNome.setLayoutY(100);

		// CRIANDO TEXT FIELD NOME
		txfCNPJ = new TextField();
		txfCNPJ.setLayoutX(550);
		txfCNPJ.setLayoutY(130);

		// CRIANDO LABEL CNPJ
		lbCnpj = new Label(Strings.lbCnpj + ":");
		lbCnpj.setLayoutX(515);
		lbCnpj.setLayoutY(130);

		// CRIANDO LABEL NOME
		lbNome = new Label(Strings.lbNome + ":");
		lbNome.setLayoutX(515);
		lbNome.setLayoutY(100);

		// CRIANDO BUTTON SELECIONAR

		btnSelecionar = new Button(Strings.btnSelecionar);
		btnSelecionar.setLayoutX(490);
		btnSelecionar.setLayoutY(215);
		btnSelecionar.setStyle(
				"-fx-padding: 0.7em 0.57em; -fx-font-size: 14px;-jfx-button-type: RAISED;-fx-background-color: rgb(155, 10, 7);-fx-pref-width: 100;-fx-text-fill: WHITE;");

		
		//System.out.println(tableView.getSelectionModel().getSelectedItem().getNome());
		
		//txfNome.setText(tableView.getSelectionModel().getSelectedItem().getNome());
		
		tableView.setOnMouseClicked(e -> setarDadosTextField(txfNome, txfCNPJ, tableView));
		
		
		pane.getChildren().add(tableView);
		pane.getChildren().add(lbTituloPesquisa);
		pane.getChildren().add(vBox);
		pane.getChildren().add(txfNome);
		pane.getChildren().add(txfCNPJ);
		pane.getChildren().add(lbNome);
		pane.getChildren().add(lbCnpj);
		pane.getChildren().add(btnSelecionar);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();

	}

	public ObservableList<Empresa> getEmpresa() {
		ObservableList<Empresa> empresaList = FXCollections.observableArrayList();

		ControladorEmpresa auxControladorEmpresa = ControladorEmpresa.getInstance();
		int tamVetor = auxControladorEmpresa.getEmpresasCadastradas().size();
		Empresa empresa = null;

		for (int i = 0; i < tamVetor; i++) {
			empresa = new Empresa(auxControladorEmpresa.getEmpresasCadastradas().get(i).getNome(),
					auxControladorEmpresa.getEmpresasCadastradas().get(i).getCnpj());
			empresaList.add(empresa);
		}

		return empresaList;
	}
	private void setarDadosTextField(TextField nome, TextField cnpj, TableView<Empresa> tableView) {
		System.out.println("OLA");
	}
}
