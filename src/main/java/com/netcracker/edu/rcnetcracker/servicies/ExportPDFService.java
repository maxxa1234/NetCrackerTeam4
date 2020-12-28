package com.netcracker.edu.rcnetcracker.servicies;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.netcracker.edu.rcnetcracker.model.Logger;

import javax.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ExportPDFService {

    List<Logger> loggerList;

    public ExportPDFService(List<Logger> loggerList) {
        this.loggerList = loggerList;
    }

    private void writeTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.YELLOW);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK);

        cell.setPhrase(new Phrase("ID",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("E-key ID",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Entrance ID",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Date",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Time",font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table){
        for(Logger logger : loggerList){
            table.addCell(logger.getId().toString());
            table.addCell(logger.geteKeyId().toString());
            table.addCell(logger.getEntranceId().toString());
            table.addCell(logger.getDate());
            table.addCell(logger.getTime());
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setColor(Color.BLUE);
        font.setSize(18);

        Paragraph title = new Paragraph("Logger",font);
        document.add(title);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setSpacingBefore(15);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }
}
