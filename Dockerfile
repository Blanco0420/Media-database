FROM openjdk


EXPOSE 8080
COPY ./backend /backend
COPY entrypoint.sh /entrypoint.sh
ENTRYPOINT [ "/entrypoint.sh" ]