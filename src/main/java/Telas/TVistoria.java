package Telas;


import Controladores.ControladorEmpresa;
import Entidades.Empresa;
import Entidades.TBVEmpresa;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TVistoria extends Application{
	private String usuario;
	private ControladorEmpresa controladorEmpresa;
	private TableView<Empresa> tableView;
	private ObservableList<TBVEmpresa> dados;
	
	public TVistoria(String usuario, ControladorEmpresa empresa) {
		this.usuario = usuario;
		this.controladorEmpresa = empresa;
	}

	public TVistoria(String usuario) {
		this.usuario = usuario;
	}
	

	@Override
	public void start(Stage stage) throws Exception {
		AnchorPane pane = new AnchorPane();
		Scene scene = new Scene(pane);
		pane.setPrefSize(700, 500);
		
		dados = FXCollections.observableArrayList();
		dados.add(new TBVEmpresa("ola", "ola"));
		
		//Nome da coluna empresa
		TableColumn<Empresa, String> nomeColumnEmpresa = new TableColumn<>("Nome");
		nomeColumnEmpresa.setMinWidth(200);
		nomeColumnEmpresa.setCellValueFactory(new PropertyValueFactory<Empresa, String>("nome"));
	//	nomeColumnEmpresa.setCellFactory(TextFieldTableCell.forTableColumn());
		
		//Nome da coluna CNPJ
		TableColumn<Empresa, String> nomeColumnCNPJ = new TableColumn<>("CNPJ");
		nomeColumnCNPJ.setMinWidth(200);
		nomeColumnCNPJ.setCellValueFactory(new PropertyValueFactory<Empresa, String>("cnpj"));
		
		
		
		tableView = new TableView<Empresa>();
		tableView.setItems(getEmpresa());
		tableView.getColumns().add(nomeColumnEmpresa);
		tableView.getColumns().add(nomeColumnCNPJ);
		
		pane.getChildren().add(tableView);
		
		stage.setScene(scene);
		stage.show();
		
	}
	
	public ObservableList<Empresa> getEmpresa(){
		ObservableList<Empresa> empresaList = FXCollections.observableArrayList();
		
		try {
			empresaList.add(new Empresa("Ola", "47963075000131"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		ControladorEmpresa auxControladorEmpresa =  ControladorEmpresa.getInstance();
//		int tamVetor = auxControladorEmpresa.getEmpresasCadastradas().size();
//		Empresa empresa = null;
	
		
//		for (int i = 0; i < tamVetor; i++) {
//			 empresa = new Empresa(auxControladorEmpresa.getEmpresasCadastradas().get(i).getNome(), auxControladorEmpresa.getEmpresasCadastradas().get(i).getDocumento());
//			 System.out.println(empresa.getNome()+" "+empresa.getDocumento());
//			 empresaList.add(empresa);
//		}
		//System.out.println(empresaList);
		
		return empresaList;
	}
}
