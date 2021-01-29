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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

        cell.setPhrase(new Phrase("User",font));
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
            table.addCell(logger.geteKeyId().getUser().getLastName());
            table.addCell(logger.geteKeyId().getName());
            table.addCell(logger.getEntranceId().getName() );

            Date date = logger.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMMM d, yyyy", Locale.ENGLISH);
            DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            table.addCell(dateFormat.format(date));
            table.addCell(timeFormat.format(date));

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
