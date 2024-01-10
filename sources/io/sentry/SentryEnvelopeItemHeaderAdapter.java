package io.sentry;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import io.sentry.util.StringUtils;
import java.io.IOException;
import java.util.Locale;

public final class SentryEnvelopeItemHeaderAdapter extends TypeAdapter<SentryEnvelopeItemHeader> {
    public void write(JsonWriter jsonWriter, SentryEnvelopeItemHeader sentryEnvelopeItemHeader) throws IOException {
        if (sentryEnvelopeItemHeader == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        if (sentryEnvelopeItemHeader.getContentType() != null) {
            jsonWriter.name(FirebaseAnalytics.Param.CONTENT_TYPE);
            jsonWriter.value(sentryEnvelopeItemHeader.getContentType());
        }
        if (sentryEnvelopeItemHeader.getFileName() != null) {
            jsonWriter.name("filename");
            jsonWriter.value(sentryEnvelopeItemHeader.getFileName());
        }
        if (!SentryItemType.Unknown.equals(sentryEnvelopeItemHeader.getType())) {
            jsonWriter.name("type");
            jsonWriter.value(sentryEnvelopeItemHeader.getType().getItemType().toLowerCase(Locale.ROOT));
        }
        jsonWriter.name("length");
        jsonWriter.value((long) sentryEnvelopeItemHeader.getLength());
        jsonWriter.endObject();
    }

    public SentryEnvelopeItemHeader read(JsonReader jsonReader) throws IOException {
        String str = null;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        SentryItemType sentryItemType = SentryItemType.Unknown;
        jsonReader.beginObject();
        String str2 = null;
        int i = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1106363674:
                    if (nextName.equals("length")) {
                        c = 3;
                        break;
                    }
                    break;
                case -734768633:
                    if (nextName.equals("filename")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals("type")) {
                        c = 2;
                        break;
                    }
                    break;
                case 831846208:
                    if (nextName.equals(FirebaseAnalytics.Param.CONTENT_TYPE)) {
                        c = 0;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c == 1) {
                str2 = jsonReader.nextString();
            } else if (c == 2) {
                try {
                    sentryItemType = SentryItemType.valueOf(StringUtils.capitalize(jsonReader.nextString()));
                } catch (IllegalArgumentException unused) {
                }
            } else if (c != 3) {
                jsonReader.skipValue();
            } else {
                i = jsonReader.nextInt();
            }
        }
        jsonReader.endObject();
        return new SentryEnvelopeItemHeader(sentryItemType, i, str, str2);
    }
}
