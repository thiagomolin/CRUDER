package cruder.main;

import java.time.LocalDate;

public class Cliente{

	private long pk_cliente;
	private long fk_pais;
	private long fk_estado;
	private long fk_cidade;
	private String nm_cliente;
	private String ds_telefone;
	private LocalDate dt_nascimento;
	private int nr_dependentes;
	private String ds_endereco;

	public Cliente(long fk_pais, long fk_estado, long fk_cidade, String nm_cliente, String ds_telefone, LocalDate dt_nascimento, int nr_dependentes, String ds_endereco){
		this.fk_pais = fk_pais;
		this.fk_estado = fk_estado;
		this.fk_cidade = fk_cidade;
		this.nm_cliente = nm_cliente;
		this.ds_telefone = ds_telefone;
		this.dt_nascimento = dt_nascimento;
		this.nr_dependentes = nr_dependentes;
		this.ds_endereco = ds_endereco;
	}

	public Cliente(long pk_cliente, long fk_pais, long fk_estado, long fk_cidade, String nm_cliente, String ds_telefone, LocalDate dt_nascimento, int nr_dependentes, String ds_endereco){
		this.pk_cliente = pk_cliente;
		this.fk_pais = fk_pais;
		this.fk_estado = fk_estado;
		this.fk_cidade = fk_cidade;
		this.nm_cliente = nm_cliente;
		this.ds_telefone = ds_telefone;
		this.dt_nascimento = dt_nascimento;
		this.nr_dependentes = nr_dependentes;
		this.ds_endereco = ds_endereco;
	}

	public long getpk_cliente(){
		return this.pk_cliente;
	}

	public long getfk_pais(){
		return this.fk_pais;
	}

	public long getfk_estado(){
		return this.fk_estado;
	}

	public long getfk_cidade(){
		return this.fk_cidade;
	}

	public String getnm_cliente(){
		return this.nm_cliente;
	}

	public String getds_telefone(){
		return this.ds_telefone;
	}

	public LocalDate getdt_nascimento(){
		return this.dt_nascimento;
	}

	public int getnr_dependentes(){
		return this.nr_dependentes;
	}

	public String getds_endereco(){
		return this.ds_endereco;
	}

	public void setpk_cliente(long pk_cliente){
		this.pk_cliente = pk_cliente;
	}

	public void setfk_pais(long fk_pais){
		this.fk_pais = fk_pais;
	}

	public void setfk_estado(long fk_estado){
		this.fk_estado = fk_estado;
	}

	public void setfk_cidade(long fk_cidade){
		this.fk_cidade = fk_cidade;
	}

	public void setnm_cliente(String nm_cliente){
		this.nm_cliente = nm_cliente;
	}

	public void setds_telefone(String ds_telefone){
		this.ds_telefone = ds_telefone;
	}

	public void setdt_nascimento(LocalDate dt_nascimento){
		this.dt_nascimento = dt_nascimento;
	}

	public void setnr_dependentes(int nr_dependentes){
		this.nr_dependentes = nr_dependentes;
	}

	public void setds_endereco(String ds_endereco){
		this.ds_endereco = ds_endereco;
	}

	public String toString(){
		return "Cliente" + " - " + this.pk_cliente;
	}
}