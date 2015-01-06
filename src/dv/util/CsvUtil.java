package dv.util;

import java.util.List;

import dv.sys.entity.Ttotdzrpt;
import dv.sys.entity.TtotdzrptNb;
import dv.sys.entity.TtotdzrptShnbjs;
import dv.sys.entity.TtotdzrptShwbjs;
import dv.sys.entity.TtotdzrptWb;

public class CsvUtil {	
	/**
	 * WebCheckAll导出
	 * @param list
	 * @return
	 */
	public static String dvtlistToStrnb(List<TtotdzrptShnbjs> list){
		StringBuffer sb=new StringBuffer();
		sb.append("组织编码,报表日期,组织编码,组织名称,配送金额,退货金额,报损金额,作料金额,门店质量,顾客退货,损耗,手工抹零,口袋金额,过期退货,卡存款,刷卡消费,积分支付金额,总结算金额\r\n");
		for (TtotdzrptShnbjs nb : list) {
			sb.append("\t"+nb.getEntid()+",");                                                   
			sb.append("\t"+nb.getRptdate()+",");                                                 
			sb.append("\t"+nb.getOrgcode()+",");                                                 
			sb.append("\t"+nb.getOrgname()+",");                                                 
			sb.append("\t"+nb.getPstotal()+",");                                                 
			sb.append("\t"+nb.getThtotal()+",");                                                 
			sb.append("\t"+nb.getBstotal()+",");                                                 
			sb.append("\t"+nb.getZltotal()+",");                                                 
			sb.append("\t"+nb.getMdzl()+",");                                                   	
			sb.append("\t"+nb.getGkth()+",");                                                   	
			sb.append("\t"+nb.getSunhaototal()+",");                                             
			sb.append("\t"+nb.getSgmltotal()+",");                                               
			sb.append("\t"+nb.getKdtotal()+",");                                                 
			sb.append("\t"+nb.getGqtotal()+",");                                                 
			sb.append("\t"+nb.getSavetotal()+",");                                               
			sb.append("\t"+nb.getSstotal()+",");                                                 
			sb.append("\t"+nb.getJfzftotal()+",");                                               
			sb.append("\t"+nb.getCqtotal()+"\r\n");
		}
		String str=sb.toString();
		return str;
	}
	public static String dvtlistToStrzy(List<Ttotdzrpt> list){
		StringBuffer sb=new StringBuffer();
		sb.append("组织编码,报表日期,组织编码,组织名称,配送金额,退货金额,报损金额,作料金额,门店质量,顾客退货,损耗,手工抹零,口袋金额,过期退货,卡存款,刷卡消费,积分支付金额,总结算金额\r\n");
		for (Ttotdzrpt zy : list) {             
			sb.append("\t"+zy.getTid()+",");			
			sb.append("\t"+zy.getEntid()+",");        
			sb.append("\t"+zy.getRptdate()+",");      
			sb.append("\t"+zy.getOrgcode()+",");      
			sb.append("\t"+zy.getOrgname()+",");      
			sb.append("\t"+zy.getQctotal()+",");      
			sb.append("\t"+zy.getPstotal()+",");      
			sb.append("\t"+zy.getThtotal()+",");      
			sb.append("\t"+zy.getDbtotal()+",");      
			sb.append("\t"+zy.getBstotal()+",");       
			sb.append("\t"+zy.getQmtotal()+",");       
			sb.append("\t"+zy.getXstotalA()+",");     
			sb.append("\t"+zy.getSunhaototal()+",");  
			sb.append("\t"+zy.getXstotalB()+",");     
			sb.append("\t"+zy.getXstotalDiff()+",");    
			sb.append("\t"+zy.getXsyjtotal()+",");    
			sb.append("\t"+zy.getSavetotal()+",");    
			sb.append("\t"+zy.getSstotal()+",");      
			sb.append("\t"+zy.getZjtotal()+",");
			sb.append("\t"+zy.getJktotal()+",");
			sb.append("\t"+zy.getCqtotal()+",");
			sb.append("\t"+zy.getZctotal()+"\r\n");   
		}                                             
		String str=sb.toString();                     
		return str;                                   
	}
	public static String dvtlistToStrwb(List<TtotdzrptShwbjs> list){
		StringBuffer sb=new StringBuffer();
		sb.append("组织编码,报表日期,组织编码,组织名称,配送金额,配送异常金额,过期退货,作料金额,门店质量,包材,会员折扣,特许费用,商标使用费,卡存款,刷卡消费,积分支付金额,总结算金额\r\n");
		for (TtotdzrptShwbjs wb : list) {
			sb.append("\t"+wb.getEntid()+",");                          
			sb.append("\t"+wb.getRptdate()+",");                        
			sb.append("\t"+wb.getOrgcode()+",");                        
			sb.append("\t"+wb.getOrgname()+",");                        
			sb.append("\t"+wb.getPstotal()+",");                        
			sb.append("\t"+wb.getThtotal()+",");                        
			sb.append("\t"+wb.getGqtotal()+",");                        
			sb.append("\t"+wb.getZltotal()+",");                        
			sb.append("\t"+wb.getMdzl()+",");                           
			sb.append("\t"+wb.getBctotal()+",");                      
			sb.append("\t"+wb.getHytotal()+",");                        
			sb.append("\t"+wb.getTxtotal()+",");                        
			sb.append("\t"+wb.getSbtotal()+",");                        
			sb.append("\t"+wb.getSavetotal()+",");                      
			sb.append("\t"+wb.getSstotal()+",");                        
			sb.append("\t"+wb.getJfzftotal()+",");                      
			sb.append("\t"+wb.getCqtotal()+"\r\n");
		}
		String str=sb.toString();
		return str;
	}
	public static String dvtlistToStrnbjm(List<TtotdzrptNb> list){
		StringBuffer sb=new StringBuffer();
		sb.append("账单编号,组织编码,报表日期,组织编码,组织名称,期初金额,配送金额,退货金额,报损金额,期末金额,倒推,损耗,实收合计,差账,口袋,过期,门店质量,活动\r\n");
		for (TtotdzrptNb nbjm : list) {             
			sb.append("\t"+nbjm.getTid()+",");			
			sb.append("\t"+nbjm.getEntid()+",");        
			sb.append("\t"+nbjm.getRptdate()+",");      
			sb.append("\t"+nbjm.getOrgcode()+",");      
			sb.append("\t"+nbjm.getOrgname()+",");      
			sb.append("\t"+nbjm.getQctotal()+",");      
			sb.append("\t"+nbjm.getPstotal()+",");      
			sb.append("\t"+nbjm.getThtotal()+",");      
			sb.append("\t"+nbjm.getBstotal()+",");       
			sb.append("\t"+nbjm.getQmtotal()+",");       
			sb.append("\t"+nbjm.getXstotalA()+",");     
			sb.append("\t"+nbjm.getSunhaototal()+",");  
			sb.append("\t"+nbjm.getXstotalB()+",");     
			sb.append("\t"+nbjm.getXstotalDiff()+",");    
			sb.append("\t"+nbjm.getKdtotal()+",");
			sb.append("\t"+nbjm.getGqtotal()+",");
			sb.append("\t"+nbjm.getMdzl()+",");
			sb.append("\t"+nbjm.getHdtotal()+"\r\n");   
		}                                             
		String str=sb.toString();                     
		return str;                                   
	}
	public static String dvtlistToStrwbjm(List<TtotdzrptWb> list){
		StringBuffer sb=new StringBuffer();
		sb.append("账单编号,组织编码,报表日期,组织编码,组织名称,期初金额,配送金额,退货金额,报损金额,期末金额,倒推,损耗,实收合计,差账,口袋,过期,门店质量,活动\r\n");
		for (TtotdzrptWb wbjm : list) {             
			sb.append("\t"+wbjm.getTid()+",");			
			sb.append("\t"+wbjm.getEntid()+",");        
			sb.append("\t"+wbjm.getRptdate()+",");      
			sb.append("\t"+wbjm.getOrgcode()+",");      
			sb.append("\t"+wbjm.getOrgname()+",");      
			sb.append("\t"+wbjm.getQctotal()+",");      
			sb.append("\t"+wbjm.getPstotal()+",");      
			sb.append("\t"+wbjm.getThtotal()+",");      
			sb.append("\t"+wbjm.getBstotal()+",");       
			sb.append("\t"+wbjm.getQmtotal()+",");       
			sb.append("\t"+wbjm.getXstotalA()+",");     
			sb.append("\t"+wbjm.getSunhaototal()+",");  
			sb.append("\t"+wbjm.getXstotalB()+",");     
			sb.append("\t"+wbjm.getXstotalDiff()+",");    
			sb.append("\t"+wbjm.getKdtotal()+",");
			sb.append("\t"+wbjm.getGqtotal()+",");
			sb.append("\t"+wbjm.getMdzl()+",");
			sb.append("\t"+wbjm.getHdtotal()+"\r\n");   
		}                                             
		String str=sb.toString();                     
		return str;                                   
	}
}
