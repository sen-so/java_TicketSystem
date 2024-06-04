REST(Spring Boot) rozhraní pro ticketovací systém na pobočcce:


Aplikace vystavuje pořadová čísla s datem a časem vygenerování.
Umí vytvořit nové tickety, zobrazit celý seznam ticketů, ticket s aktuálním pořadovým číslem (0) a smazání posledního záznamu.

Business logika je uložena v /java/service/TicketServiceImpl.
Komunikace s DB je řešená přes JPA repozitář.


Endpointy pro Ticket entitu:
POST /api/tickets              Vytvoření nového ticketu
GET /api/tickets               Zobrazení všech ticketů
GET /api/actualTicket          Zobrazení aktuálního ticketu (pořadové č. 0)
DELETE /api/deleteLastTicket   Smazání posledně uloženého ticketu
