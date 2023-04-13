package com.frederico.empresa.tipos;

import java.math.BigDecimal;
import java.math.MathContext;

import com.frederico.empresa.entity.Emprestimo;

// enum para realizar calculo de valor final
public enum Relacionamento {
	
	Bronze(1){
		@Override
		public BigDecimal calculaValorFinal(Emprestimo emprestimo) {
			BigDecimal fatorMultiplicador = new BigDecimal(1.8);
			return emprestimo.getValorInicial().multiply(fatorMultiplicador, MathContext.DECIMAL32);
		}	
	},

	Prata(2){
		@Override
		public BigDecimal calculaValorFinal(Emprestimo emprestimo) {
			int validador = emprestimo.getValorInicial().compareTo(new BigDecimal(5000));
			if(validador < 1) {
				BigDecimal fatorMultiplicador = new BigDecimal(1.6);
				return emprestimo.getValorInicial().multiply(fatorMultiplicador, MathContext.DECIMAL32);
			}else {
				BigDecimal fatorMultiplicador = new BigDecimal(1.4);
				return emprestimo.getValorInicial().multiply(fatorMultiplicador, MathContext.DECIMAL32);
			}
		}	
	},
	
	Ouro(3){
		@Override
		public BigDecimal calculaValorFinal(Emprestimo emprestimo) {
			if(emprestimo.getCliente().getEmprestimos().size() <= 1){
				BigDecimal fatorMultiplicador = new BigDecimal(1.2);
				return emprestimo.getValorInicial().multiply(fatorMultiplicador, MathContext.DECIMAL32);
			}
			else {
				BigDecimal fatorMultiplicador = new BigDecimal(1.3);
				return emprestimo.getValorInicial().multiply(fatorMultiplicador, MathContext.DECIMAL32);
			}
		}	
	};
		
		private int codigo;
		 
	    private Relacionamento(int codigo) {
	        this.codigo = codigo;
	    }
	 
	    public int getCodigo() { 
	        return this.codigo;
	    }
	    
	    public abstract BigDecimal calculaValorFinal(Emprestimo emprestimo);

}
