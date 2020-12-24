package com.netcracker.edu.rcnetcracker.servicies;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.netcracker.edu.rcnetcracker.model.Entrance;

import javax.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ExportPDFService {
    List<Entrance> entranceList;

    public ExportPDFService(List<Entrance> entranceList) {
        this.entranceList = entranceList;
    }

    private void writeTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.YELLOW);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK);

        cell.setPhrase(new Phrase("entrance ID",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("name",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("description",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("typeId",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("isActive",font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table){
        for(Entrance entrance : entranceList){
            table.addCell(entrance.getId().toString());
            table.addCell(entrance.getName());
            table.addCell(entrance.getDescription());
            table.addCell(entrance.getTypeId().toString());
            table.addCell(entrance.getActive().toString());
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setColor(Color.BLUE);
        font.setSize(18);

        Paragraph title = new Paragraph("List of entrance",font);
        document.add(title);


        PdfPTable table = new PdfPTable(5); //TODO: заменить на число столбцов
        table.setWidthPercentage(100);
        table.setSpacingBefore(15);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }
}
