package io.skalogs.skaetl.service.transform;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.skalogs.skaetl.domain.ParameterTransformation;
import io.skalogs.skaetl.domain.TypeValidation;
import io.skalogs.skaetl.service.TransformatorProcess;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
public class DateExtractorTransformator extends TransformatorProcess {

    public DateExtractorTransformator(TypeValidation type) {
        super(type);
    }

    public void apply(String idProcess, ParameterTransformation parameterTransformation, ObjectNode jsonValue) {
        String valueToFormat = at(parameterTransformation.getFormatDateValue().getKeyField(), jsonValue).asText();
        if (StringUtils.isNotBlank(valueToFormat)) {
            DateFormat df1 = new SimpleDateFormat(parameterTransformation.getFormatDateValue().getSrcFormat());
            try {
                Date asDate = df1.parse(valueToFormat);
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(parameterTransformation.getFormatDateValue().getTargetFormat());
                String result = asDate.toInstant().atZone(ZoneId.systemDefault()).format(dateTimeFormatter);
                put(jsonValue, parameterTransformation.getFormatDateValue().getTargetField(), result);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }
}