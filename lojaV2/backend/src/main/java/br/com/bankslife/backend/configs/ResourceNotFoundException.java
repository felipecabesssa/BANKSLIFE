package br.com.bankslife.backend.configs;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Essa Categoria ou Produto não existe: " + id);
	}

}
