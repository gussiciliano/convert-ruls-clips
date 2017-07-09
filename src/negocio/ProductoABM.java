package negocio;

import java.util.Iterator;

import dao.ProductoDao;
import datos.Producto;

public class ProductoABM extends MasterABM<Producto>{
	
	public ProductoABM() {
		super(new ProductoDao());
	}
	
	public String defTemplateProducto(){
//		(deftemplate producto
//				  (slot codigo
//					(type SYMBOL)
//					(allowed-symbols estimac asig-recursos metricas-def))
//				  (slot descripcion 
//					(type STRING))
//				  (slot estado
//					(type SYMBOL)
//					(allowed-symbols no-disponible en-curso disponible))
//				  (slot origen 
//					(type SYMBOL)
//					(allowed-symbols interno-externo)))
		
		ProductoDao pd=(ProductoDao) this.getDao();
		
		StringBuffer template=new StringBuffer(300);
		template.append("(deftemplate producto\n");
		template.append("    (slot codigo\n");
		template.append("        (type SYMBOL)\n");
		template.append("        (allowed-symbols ");
		//template.append("                         ");
		Iterator<Producto> i=pd.traerTodos().iterator();
		int contador=0;
		while(i.hasNext()){
			Producto p=i.next();
			template.append(p.getCodigo());
			if(contador<6){
				template.append(" ");
				contador++;
			}else{
				contador=0;
				if(i.hasNext()){
					template.append("\n                         ");
				}
			}
		}
		template.append("))\n");
		template.append("    (slot nombre\n");        
		template.append("        (type STRING))\n");
		template.append("    (slot estado\n");
		template.append("        (type SYMBOL)\n");
		template.append("        (allowed-symbols no-disponible en-curso disponible))\n");
		template.append("    (slot origen\n");
		template.append("        (type SYMBOL)\n");
		template.append("        (allowed-symbols interno externo)))\n\n");    
		return template.toString();		
	}
	
}