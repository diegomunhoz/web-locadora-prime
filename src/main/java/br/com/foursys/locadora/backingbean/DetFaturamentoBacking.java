package br.com.foursys.locadora.backingbean;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.NumberFormat;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.foursys.locadora.util.Constantes;

@ManagedBean(name = "detFaturamentoBacking")
@RequestScoped
public class DetFaturamentoBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	private StreamedContent graphicText;

	private StreamedContent chart;

	private String anoPesquisa;

	private String fatJaneiro;
	private String fatFevereiro;
	private String fatMarco;
	private String fatAbril;
	private String fatMaio;
	private String fatJunho;
	private String fatJulho;
	private String fatAgosto;
	private String fatSetembro;
	private String fatOutubro;
	private String fatNovembro;
	private String fatDezembro;

	private double valorJaneiro;
	private double valorFevereiro;
	private double valorMarco;
	private double valorAbril;
	private double valorMaio;
	private double valorJunho;
	private double valorJulho;
	private double valorAgosto;
	private double valorSetembro;
	private double valorOutubro;
	private double valorNovembro;
	private double valorDezembro;

	public DetFaturamentoBacking() {
		valorInicial();
		gerarGrafico();
		carregarLabel();
	}

	public String getAnoPesquisa() {
		return anoPesquisa;
	}

	public void setAnoPesquisa(String anoPesquisa) {
		this.anoPesquisa = anoPesquisa;
	}

	public String getFatJaneiro() {
		return fatJaneiro;
	}

	public void setFatJaneiro(String fatJaneiro) {
		this.fatJaneiro = fatJaneiro;
	}

	public String getFatFevereiro() {
		return fatFevereiro;
	}

	public void setFatFevereiro(String fatFevereiro) {
		this.fatFevereiro = fatFevereiro;
	}

	public String getFatMarco() {
		return fatMarco;
	}

	public void setFatMarco(String fatMarco) {
		this.fatMarco = fatMarco;
	}

	public String getFatAbril() {
		return fatAbril;
	}

	public void setFatAbril(String fatAbril) {
		this.fatAbril = fatAbril;
	}

	public String getFatMaio() {
		return fatMaio;
	}

	public void setFatMaio(String fatMaio) {
		this.fatMaio = fatMaio;
	}

	public String getFatJunho() {
		return fatJunho;
	}

	public void setFatJunho(String fatJunho) {
		this.fatJunho = fatJunho;
	}

	public String getFatJulho() {
		return fatJulho;
	}

	public void setFatJulho(String fatJulho) {
		this.fatJulho = fatJulho;
	}

	public String getFatAgosto() {
		return fatAgosto;
	}

	public void setFatAgosto(String fatAgosto) {
		this.fatAgosto = fatAgosto;
	}

	public String getFatSetembro() {
		return fatSetembro;
	}

	public void setFatSetembro(String fatSetembro) {
		this.fatSetembro = fatSetembro;
	}

	public String getFatOutubro() {
		return fatOutubro;
	}

	public void setFatOutubro(String fatOutubro) {
		this.fatOutubro = fatOutubro;
	}

	public String getFatNovembro() {
		return fatNovembro;
	}

	public void setFatNovembro(String fatNovembro) {
		this.fatNovembro = fatNovembro;
	}

	public String getFatDezembro() {
		return fatDezembro;
	}

	public void setFatDezembro(String fatDezembro) {
		this.fatDezembro = fatDezembro;
	}

	public double getValorJaneiro() {
		return valorJaneiro;
	}

	public void setValorJaneiro(double valorJaneiro) {
		this.valorJaneiro = valorJaneiro;
	}

	public double getValorFevereiro() {
		return valorFevereiro;
	}

	public void setValorFevereiro(double valorFevereiro) {
		this.valorFevereiro = valorFevereiro;
	}

	public double getValorMarco() {
		return valorMarco;
	}

	public void setValorMarco(double valorMarco) {
		this.valorMarco = valorMarco;
	}

	public double getValorAbril() {
		return valorAbril;
	}

	public void setValorAbril(double valorAbril) {
		this.valorAbril = valorAbril;
	}

	public double getValorMaio() {
		return valorMaio;
	}

	public void setValorMaio(double valorMaio) {
		this.valorMaio = valorMaio;
	}

	public double getValorJunho() {
		return valorJunho;
	}

	public void setValorJunho(double valorJunho) {
		this.valorJunho = valorJunho;
	}

	public double getValorJulho() {
		return valorJulho;
	}

	public void setValorJulho(double valorJulho) {
		this.valorJulho = valorJulho;
	}

	public double getValorAgosto() {
		return valorAgosto;
	}

	public void setValorAgosto(double valorAgosto) {
		this.valorAgosto = valorAgosto;
	}

	public double getValorSetembro() {
		return valorSetembro;
	}

	public void setValorSetembro(double valorSetembro) {
		this.valorSetembro = valorSetembro;
	}

	public double getValorOutubro() {
		return valorOutubro;
	}

	public void setValorOutubro(double valorOutubro) {
		this.valorOutubro = valorOutubro;
	}

	public double getValorNovembro() {
		return valorNovembro;
	}

	public void setValorNovembro(double valorNovembro) {
		this.valorNovembro = valorNovembro;
	}

	public double getValorDezembro() {
		return valorDezembro;
	}

	public void setValorDezembro(double valorDezembro) {
		this.valorDezembro = valorDezembro;
	}

	public void gerarGrafico() {
		try {
			graphicText = DefaultStreamedContent.builder().contentType("image/png").stream(() -> {
				try {
					BufferedImage bufferedImg = new BufferedImage(100, 25, BufferedImage.TYPE_INT_RGB);
					Graphics2D g2 = bufferedImg.createGraphics();
					g2.drawString("This is a text", 0, 10);
					ByteArrayOutputStream os = new ByteArrayOutputStream();
					ImageIO.write(bufferedImg, "png", os);
					return new ByteArrayInputStream(os.toByteArray());
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}).build();

			chart = DefaultStreamedContent.builder().contentType("image/png").stream(() -> {
				try {
					JFreeChart jfreechart = ChartFactory.createPieChart("Ano: 2021", createDataset(), true, true,
							false);
					File chartFile = new File("C:\\io\\dynamichart");
					ChartUtilities.saveChartAsPNG(chartFile, jfreechart, 375, 300);
					return new FileInputStream(chartFile);
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public StreamedContent getGraphicText() {
		return graphicText;
	}

	public StreamedContent getChart() {
		return chart;
	}

	private PieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Janeiro", new Double(getValorJaneiro()));
		dataset.setValue("Fevereiro", new Double(getValorFevereiro()));
		dataset.setValue("Março", new Double(getValorMarco()));
		dataset.setValue("Abril", new Double(getValorAbril()));
		dataset.setValue("Maio", new Double(getValorMaio()));
		dataset.setValue("Junho", new Double(getValorJunho()));
		dataset.setValue("Julho", new Double(getValorJulho()));
		dataset.setValue("Agosto", new Double(getValorAgosto()));
		dataset.setValue("Setembro", new Double(getValorSetembro()));
		dataset.setValue("Outubro", new Double(getValorOutubro()));
		dataset.setValue("Novembro", new Double(getValorNovembro()));
		dataset.setValue("Dezembro", new Double(getValorDezembro()));

		return dataset;
	}

	private void carregarLabel() {
		setFatJaneiro(NumberFormat.getCurrencyInstance().format(getValorJaneiro()));
		setFatFevereiro(NumberFormat.getCurrencyInstance().format(getValorFevereiro()));
		setFatMarco(NumberFormat.getCurrencyInstance().format(getValorMarco()));
		setFatAbril(NumberFormat.getCurrencyInstance().format(getValorAbril()));
		setFatMaio(NumberFormat.getCurrencyInstance().format(getValorMaio()));
		setFatJunho(NumberFormat.getCurrencyInstance().format(getValorJunho()));
		setFatJulho(NumberFormat.getCurrencyInstance().format(getValorJulho()));
		setFatAgosto(NumberFormat.getCurrencyInstance().format(getValorAgosto()));
		setFatSetembro(NumberFormat.getCurrencyInstance().format(getValorSetembro()));
		setFatOutubro(NumberFormat.getCurrencyInstance().format(getValorOutubro()));
		setFatNovembro(NumberFormat.getCurrencyInstance().format(getValorNovembro()));
		setFatDezembro(NumberFormat.getCurrencyInstance().format(getValorDezembro()));
	}

	private void valorInicial() {
		setValorJaneiro(Constantes.DOUBLE_ZERO);
		setValorFevereiro(Constantes.DOUBLE_ZERO);
		setValorMarco(Constantes.DOUBLE_ZERO);
		setValorAbril(Constantes.DOUBLE_ZERO);
		setValorMaio(Constantes.DOUBLE_ZERO);
		setValorJunho(Constantes.DOUBLE_ZERO);
		setValorJulho(Constantes.DOUBLE_ZERO);
		setValorAgosto(Constantes.DOUBLE_ZERO);
		setValorSetembro(Constantes.DOUBLE_ZERO);
		setValorOutubro(Constantes.DOUBLE_ZERO);
		setValorNovembro(Constantes.DOUBLE_ZERO);
		setValorDezembro(Constantes.DOUBLE_ZERO);
	}

	public void pesquisar() {
		setValorJaneiro(45.5);
		setValorFevereiro(17.8);
		setValorMarco(22.62);
		setValorAbril(99.55);
		setValorMaio(32.41);
		setValorJunho(123.12);
		setValorJulho(123.23);
		setValorAgosto(135);
		setValorSetembro(32.25);
		setValorOutubro(51.00);
		setValorNovembro(32.20);
		setValorDezembro(32.0);
		gerarGrafico();
	}

	public void sair() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
