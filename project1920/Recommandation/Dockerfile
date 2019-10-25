FROM berndverst/falcon
RUN pip3 install https://github.com/psf/requests/archive/master.zip
ENV PYTHONUNBUFFERED 0

ENV PYTHONPATH "${PYTHONPATH}:/app"


EXPOSE 80
COPY ./app /app
