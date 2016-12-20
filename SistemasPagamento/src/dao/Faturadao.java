	
	package dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	import Conexao.ConnectionFactory;
	import Basicas.Fatura;

	/**
	 * @author Roberto Alencar
	 */
	public class Faturadao {

	    private Connection connection;

	    public Faturadao() {

		try {
		    this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
		    throw new RuntimeException(e);
		}
	    }

	    public void salvar(Fatura fatura) {

		String sql = "INSERT INTO FATURA (COD_FATURA,DATA_VENCIMENTO,VALOR_TOTAL,NOME_CLIENTE) VALUES (?,?,?,?)";
		PreparedStatement stmt;
		try {
		    stmt = connection.prepareStatement(sql);
		
		    stmt.setInt(1, fatura.getCodigoFatura());
		    stmt.setDate(2, new java.sql.Date(fatura.getDataVencimento().getTime()));
		    stmt.setDouble(3, fatura.getValorTotal());
		    stmt.setString(4, fatura.getNomeCliente());
		    
		    //stmt.setInt(5, fatura.getNumeroBoleto());
		    
		    stmt.execute();
		    connection.close();
		} catch (SQLException e) {
		    throw new RuntimeException(e);
		}
	    }
<<<<<<< HEAD
		
		public void alterar(Fatura fatura) {

		try {

			String sql = "UPDATE FATURA SET COD_FATURA=?, DATA_VENCIMENTO=?, VALOR_TOTAL=?, NOME_CLIENTE=? WHERE ID=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, fatura.getCodigoFatura());
		    stmt.setDate(2, new java.sql.Date(fatura.getDataVencimento().getTime()));
		    stmt.setDouble(3, fatura.getValorTotal());
		    stmt.setString(4, fatura.getNomeCliente());

			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

		public void remover(int id) {

		try {
			String sql = "DELETE FROM FATURA WHERE id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	   public List<Fatura> listar() {
=======

	    public List<Fatura> listar() {
>>>>>>> 7cd150c80efebc62554ef66f97aa9171e45d1b3c

		try {
		    List<Fatura> listaFatura = new ArrayList<Fatura>();
		    PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM FATURA ORDER BY nome");

		    ResultSet rs = stmt.executeQuery();

		    while (rs.next()) {
			listaFatura.add(montarObjeto(rs));
		    }

		    rs.close();
		    stmt.close();
		    connection.close();

		    return listaFatura;
		} catch (SQLException e) {
		    throw new RuntimeException(e);
		}
	    }

	    private Fatura montarObjeto(ResultSet rs) throws SQLException {

	    	Fatura fatura = new Fatura();
		fatura.setCodigoFatura(rs.getInt("id"));
		fatura.setNomeCliente(rs.getString("nomeCliente"));
		fatura.setValorTotal(rs.getDouble("valorTotal"));
		fatura.setNumeroBoleto(rs.getInt("numeroBoleto"));
		fatura.setDataVencimento(rs.getDate("dataNascimento"));
		return fatura;
	    }
<<<<<<< HEAD
	}
=======
	}


>>>>>>> 7cd150c80efebc62554ef66f97aa9171e45d1b3c
