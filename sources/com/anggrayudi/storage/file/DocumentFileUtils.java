package com.anggrayudi.storage.file;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.text.format.Formatter;
import androidx.core.content.FileProvider;
import androidx.core.content.MimeTypeFilter;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.SimpleStorage;
import com.anggrayudi.storage.callback.BaseFileCallback;
import com.anggrayudi.storage.callback.FileCallback;
import com.anggrayudi.storage.callback.FolderCallback;
import com.anggrayudi.storage.callback.MultipleFileCallback;
import com.anggrayudi.storage.extension.CoroutineExtKt;
import com.anggrayudi.storage.extension.IOUtils;
import com.anggrayudi.storage.extension.TextUtils;
import com.anggrayudi.storage.extension.UriUtils;
import com.anggrayudi.storage.file.FileProperties;
import com.anggrayudi.storage.media.FileDescription;
import com.anggrayudi.storage.media.MediaFile;
import com.facebook.internal.security.CertificateUtil;
import java.io.File;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.serialization.json.internal.JsonLexerKt;

@Metadata(d1 = {"\u0000\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aV\u0010\u0018\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u0002H\u001a\u0012\u0002\b\u0003\u0012\u0002\b\u00030 2\u0018\u0010!\u001a\u0014\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00190\"H\u0002\u001aC\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020&2\u0018\u0010!\u001a\u0014\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00190\"H\b\u001a<\u0010'\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001f\u001a\u00020&H\u0002\u001a(\u0010,\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020&H\u0002\u001a(\u0010/\u001a\u0002002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u000203H\u0002\u001a\u001c\u00104\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u0001H\u0007\u001a\u0012\u00106\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a$\u00107\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\f2\u0006\u00109\u001a\u00020\fH\u0007\u001a(\u0010:\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020\u00012\b\b\u0002\u00108\u001a\u00020\fH\u0007\u001aD\u0010<\u001a\u00020\u0019*\u00020\u00022\u0006\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020?2\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020&H\u0002\u001a0\u0010D\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00022\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010\u001f\u001a\u00020&H\u0007\u001a8\u0010D\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010\u00012\b\u0010G\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u00020&H\u0002\u001a$\u0010D\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020&H\u0007\u001a,\u0010D\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020%2\u0006\u0010C\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020&H\u0002\u001a0\u0010D\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020H2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010\u001f\u001a\u00020&H\u0007\u001a0\u0010D\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u00012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010\u001f\u001a\u00020&H\u0007\u001a.\u0010J\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020F2\u0006\u0010\u001f\u001a\u00020&2\b\b\u0002\u0010*\u001a\u00020+H\u0007\u001a<\u0010K\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020F2\u0006\u0010\u001f\u001a\u00020&2\u0006\u0010L\u001a\u00020M2\u0006\u0010C\u001a\u00020\f2\u0006\u0010*\u001a\u00020+H\u0002\u001a.\u0010N\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020F2\u0006\u0010\u001f\u001a\u00020&2\b\b\u0002\u0010*\u001a\u00020+H\u0007\u001a:\u0010O\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00022\b\b\u0002\u0010P\u001a\u00020\f2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u000203H\u0007\u001aB\u0010O\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00022\b\b\u0002\u0010P\u001a\u00020\f2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00012\u0006\u0010R\u001a\u00020\f2\u0006\u0010\u001f\u001a\u000203H\u0002\u001a4\u0010S\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00020T2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00022\b\b\u0002\u0010P\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020UH\u0007\u001a<\u0010S\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00020T2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00022\b\b\u0002\u0010P\u001a\u00020\f2\u0006\u0010R\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020UH\u0002\u001a(\u0010V\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010W\u001a\u00020\u00012\b\b\u0002\u0010*\u001a\u00020+H\u0007\u001a\u0012\u0010X\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u001e\u0010Y\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010Z\u001a\u00020\fH\u0007\u001a0\u0010[\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u00020&H\u0002\u001a0\u0010[\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00022\b\u0010Q\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u000203H\u0002\u001a>\u0010[\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020]\u0018\u00010\\*\b\u0012\u0004\u0012\u00020\u00020T2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020UH\u0002\u001a\u0014\u0010^\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010W\u001a\u00020\u0001\u001a-\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00020T*\u00020\u00022\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00010a2\b\b\u0002\u0010b\u001a\u00020c¢\u0006\u0002\u0010d\u001a\u0014\u0010e\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010W\u001a\u00020\u0001\u001a\u001e\u0010f\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010Z\u001a\u00020\fH\u0007\u001a\u0012\u0010g\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0012\u0010h\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u001a\u0010i\u001a\n j*\u0004\u0018\u00010\u00010\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u001c\u0010k\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020lH\u0007\u001a\u0012\u0010m\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a \u0010n\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u00108\u001a\u00020\fH\u0007\u001a\u0012\u0010o\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0012\u0010p\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0012\u0010q\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0012\u0010r\u001a\u00020s*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u001c\u0010t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010u\u001a\u00020\u0001H\u0002\u001a2\u0010/\u001a\n\u0012\u0004\u0012\u00020v\u0018\u00010T*\b\u0012\u0004\u0012\u00020\u00020T2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020UH\u0002\u001a\u001a\u0010w\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010x\u001a\u00020\u0002\u001a\u0012\u0010y\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0012\u0010z\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0012\u0010{\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u001a\u0010|\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010}\u001a\u00020\u0002\u001a\u0012\u0010~\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0014\u0010\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0007\u001a\u0013\u0010\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0013\u0010\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0013\u0010\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0013\u0010\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a5\u0010\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010W\u001a\u00020\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010*\u001a\u00020+H\u0007\u001a)\u0010\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010W\u001a\u00020\u00012\b\b\u0002\u0010*\u001a\u00020+H\u0007\u001a\"\u0010\u0001\u001a\u00020\f*\u00020\u00022\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010aH\u0002¢\u0006\u0003\u0010\u0001\u001a1\u0010\u0001\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00022\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010\u001f\u001a\u00020&H\u0007\u001a9\u0010\u0001\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010\u00012\b\u0010G\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u00020&H\u0002\u001a%\u0010\u0001\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020&H\u0007\u001a1\u0010\u0001\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020H2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010\u001f\u001a\u00020&H\u0007\u001a1\u0010\u0001\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u00012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010\u001f\u001a\u00020&H\u0007\u001a/\u0010\u0001\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020F2\u0006\u0010\u001f\u001a\u00020&2\b\b\u0002\u0010*\u001a\u00020+H\u0007\u001a/\u0010\u0001\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020F2\u0006\u0010\u001f\u001a\u00020&2\b\b\u0002\u0010*\u001a\u00020+H\u0007\u001a;\u0010\u0001\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00022\b\b\u0002\u0010P\u001a\u00020\f2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u000203H\u0007\u001a5\u0010\u0001\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00020T2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00022\b\b\u0002\u0010P\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020UH\u0007\u001a\u001f\u0010\u0001\u001a\u00030\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0007\u0010\u0001\u001a\u00020\u0001H\u0007\u001a\u0017\u0010\u0001\u001a\u0004\u0018\u00010#*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0007\u001a\"\u0010\u0001\u001a\u0004\u0018\u00010$*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\t\b\u0002\u0010\u0001\u001a\u00020\fH\u0007\u001a\u0017\u0010\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010W\u001a\u00020\u0001H\u0007\u001a)\u0010\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010W\u001a\u00020\u0001H\u0007\u001a\u0015\u0010\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001aY\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020T*\u00020\u00022\t\b\u0002\u0010\u0001\u001a\u00020\f2\b\b\u0002\u0010b\u001a\u00020c2\u0011\b\u0002\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010a2\b\b\u0002\u0010W\u001a\u00020\u00012\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010\u0001\u001a\u001d\u0010\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\fH\u0007\u001a\u0015\u0010 \u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001f\u001a\u00020&H\u0002\u001a\u001f\u0010¡\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\fH\u0007\u001a\u0014\u0010¢\u0001\u001a\u00030£\u0001*\b0¤\u0001j\u0003`¥\u0001H\u0000\u001a\u0014\u0010¦\u0001\u001a\u00030§\u0001*\b0¤\u0001j\u0003`¥\u0001H\u0002\u001a\u0015\u0010¨\u0001\u001a\u0004\u0018\u00010%*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0014\u0010©\u0001\u001a\u00030ª\u0001*\b0¤\u0001j\u0003`¥\u0001H\u0002\u001a\u0015\u0010«\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0015\u0010¬\u0001\u001a\u0004\u0018\u00010H*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0015\u0010­\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0017\u0010®\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0007\u001aC\u0010¯\u0001\u001a\u0004\u0018\u00010?*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0007\u0010°\u0001\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00012\u0006\u0010P\u001a\u00020\f2\b\u0010Q\u001a\u0004\u0018\u00010\u00012\u0007\u0010±\u0001\u001a\u000200H\u0002\u001a\u001b\u0010²\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020T*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002\u001a\u0013\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020T*\u00020\u0002H\u0002\u001a\u0013\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020T*\u00020\u0002H\u0002\u001a\u0013\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020T*\u00020\u0002H\u0002\u001a!\u0010¶\u0001\u001a\u00020\u0019*\u00020\u00022\b\u0010·\u0001\u001a\u00030¸\u00012\b\u0010¹\u0001\u001a\u00030º\u0001H\u0002\u001aO\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020T*\u00020\u00022\u0006\u0010b\u001a\u00020c2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010a2\u0007\u0010¼\u0001\u001a\u00020\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010¹\u0001\u001a\u00030º\u0001H\u0002¢\u0006\u0003\u0010½\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004\"\u0015\u0010\u000b\u001a\u00020\f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r\"\u0015\u0010\u000e\u001a\u00020\f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\r\"\u0015\u0010\u000f\u001a\u00020\f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r\"\u0015\u0010\u0010\u001a\u00020\f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\r\"\u0015\u0010\u0011\u001a\u00020\f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\r\"\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0004\"\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0004\"\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0004¨\u0006¾\u0001"}, d2 = {"baseName", "", "Landroidx/documentfile/provider/DocumentFile;", "getBaseName", "(Landroidx/documentfile/provider/DocumentFile;)Ljava/lang/String;", "extension", "getExtension", "fullName", "getFullName", "id", "getId", "isDownloadsDocument", "", "(Landroidx/documentfile/provider/DocumentFile;)Z", "isExternalStorageDocument", "isMediaDocument", "isRawFile", "isTreeDocumentFile", "mimeType", "getMimeType", "mimeTypeByFileName", "getMimeTypeByFileName", "rootId", "getRootId", "createFileStreams", "", "Enum", "context", "Landroid/content/Context;", "sourceFile", "targetFile", "callback", "Lcom/anggrayudi/storage/callback/BaseFileCallback;", "onStreamsReady", "Lkotlin/Function2;", "Ljava/io/InputStream;", "Ljava/io/OutputStream;", "Lcom/anggrayudi/storage/media/MediaFile;", "Lcom/anggrayudi/storage/callback/FileCallback;", "createTargetFile", "targetFolder", "newFilenameInTargetPath", "mode", "Lcom/anggrayudi/storage/file/CreateMode;", "handleFileConflict", "Lcom/anggrayudi/storage/callback/FileCallback$ConflictResolution;", "targetFileName", "handleParentFolderConflict", "Lcom/anggrayudi/storage/callback/FolderCallback$ConflictResolution;", "targetParentFolder", "targetFolderParentName", "Lcom/anggrayudi/storage/callback/FolderCallback;", "autoIncrementFileName", "filename", "canModify", "checkRequirements", "requiresWriteAccess", "considerRawFile", "child", "path", "copyFileStream", "inputStream", "outputStream", "", "watchProgress", "reportInterval", "", "deleteSourceFileWhenComplete", "copyFileTo", "fileDescription", "Lcom/anggrayudi/storage/media/FileDescription;", "newMimeTypeInTargetPath", "Ljava/io/File;", "targetFolderAbsolutePath", "copyFileToDownloadMedia", "copyFileToMedia", "publicDirectory", "Lcom/anggrayudi/storage/file/PublicDirectory;", "copyFileToPictureMedia", "copyFolderTo", "skipEmptyFiles", "newFolderNameInTargetPath", "deleteSourceWhenComplete", "copyTo", "", "Lcom/anggrayudi/storage/callback/MultipleFileCallback;", "createBinaryFile", "name", "deleteEmptyFolders", "deleteRecursively", "childrenOnly", "doesMeetCopyRequirements", "Lkotlin/Pair;", "", "findFileLiterally", "findFiles", "names", "", "documentType", "Lcom/anggrayudi/storage/file/DocumentFileType;", "(Landroidx/documentfile/provider/DocumentFile;[Ljava/lang/String;Lcom/anggrayudi/storage/file/DocumentFileType;)Ljava/util/List;", "findFolder", "forceDelete", "getAbsolutePath", "getBasePath", "getFormattedSize", "kotlin.jvm.PlatformType", "getProperties", "Lcom/anggrayudi/storage/file/FileProperties$CalculationCallback;", "getRelativePath", "getRootDocumentFile", "getRootPath", "getSimplePath", "getStorageId", "getStorageType", "Lcom/anggrayudi/storage/file/StorageType;", "getSubPath", "otherFolderAbsolutePath", "Lcom/anggrayudi/storage/callback/MultipleFileCallback$ParentConflict;", "hasParent", "parent", "inDataStorage", "inInternalStorage", "inPrimaryStorage", "inSameMountPointWith", "file", "inSdCardStorage", "isEmpty", "isExternalStorageManager", "isReadOnly", "isRootUriPermissionGranted", "isWritable", "makeFile", "makeFolder", "matchesMimeTypes", "filterMimeTypes", "(Landroidx/documentfile/provider/DocumentFile;[Ljava/lang/String;)Z", "moveFileTo", "moveFileToDownloadMedia", "moveFileToPictureMedia", "moveFolderTo", "moveTo", "openFileIntent", "Landroid/content/Intent;", "authority", "openInputStream", "openOutputStream", "append", "quickFindRawFile", "quickFindTreeFile", "resolver", "Landroid/content/ContentResolver;", "recreateFile", "search", "recursive", "mimeTypes", "regex", "Lkotlin/text/Regex;", "(Landroidx/documentfile/provider/DocumentFile;ZLcom/anggrayudi/storage/file/DocumentFileType;[Ljava/lang/String;Ljava/lang/String;Lkotlin/text/Regex;)Ljava/util/List;", "shouldWritable", "simpleCheckSourceFile", "takeIfWritable", "toFileCallbackErrorCode", "Lcom/anggrayudi/storage/callback/FileCallback$ErrorCode;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "toFolderCallbackErrorCode", "Lcom/anggrayudi/storage/callback/FolderCallback$ErrorCode;", "toMediaFile", "toMultipleFileCallbackErrorCode", "Lcom/anggrayudi/storage/callback/MultipleFileCallback$ErrorCode;", "toRawDocumentFile", "toRawFile", "toTreeDocumentFile", "toWritableDownloadsDocumentFile", "tryMoveFolderByRenamingPath", "writableTargetParentFolder", "conflictResolution", "walkFileTree", "walkFileTreeAndDeleteEmptyFolders", "walkFileTreeAndSkipEmptyFiles", "walkFileTreeForDeletion", "walkFileTreeForInfo", "properties", "Lcom/anggrayudi/storage/file/FileProperties;", "thread", "Ljava/lang/Thread;", "walkFileTreeForSearch", "nameFilter", "(Landroidx/documentfile/provider/DocumentFile;Lcom/anggrayudi/storage/file/DocumentFileType;[Ljava/lang/String;Ljava/lang/String;Lkotlin/text/Regex;Ljava/lang/Thread;)Ljava/util/List;", "storage_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DocumentFileExt.kt */
public final class DocumentFileUtils {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DocumentFileExt.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[DocumentFileType.values().length];
            iArr[DocumentFileType.FILE.ordinal()] = 1;
            iArr[DocumentFileType.FOLDER.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FolderCallback.ErrorCode.values().length];
            iArr2[FolderCallback.ErrorCode.INVALID_TARGET_FOLDER.ordinal()] = 1;
            iArr2[FolderCallback.ErrorCode.STORAGE_PERMISSION_DENIED.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[FolderCallback.ConflictResolution.values().length];
            iArr3[FolderCallback.ConflictResolution.REPLACE.ordinal()] = 1;
            iArr3[FolderCallback.ConflictResolution.MERGE.ordinal()] = 2;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static final DocumentFile child(DocumentFile documentFile, Context context, String str) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "path");
        return child$default(documentFile, context, str, false, 4, (Object) null);
    }

    public static final void copyFileToDownloadMedia(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback fileCallback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "fileDescription");
        Intrinsics.checkNotNullParameter(fileCallback, "callback");
        copyFileToDownloadMedia$default(documentFile, context, fileDescription, fileCallback, (CreateMode) null, 8, (Object) null);
    }

    public static final void copyFileToPictureMedia(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback fileCallback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "fileDescription");
        Intrinsics.checkNotNullParameter(fileCallback, "callback");
        copyFileToPictureMedia$default(documentFile, context, fileDescription, fileCallback, (CreateMode) null, 8, (Object) null);
    }

    public static final DocumentFile createBinaryFile(DocumentFile documentFile, Context context, String str) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        return createBinaryFile$default(documentFile, context, str, (CreateMode) null, 4, (Object) null);
    }

    public static final boolean deleteRecursively(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return deleteRecursively$default(documentFile, context, false, 2, (Object) null);
    }

    public static final boolean forceDelete(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return forceDelete$default(documentFile, context, false, 2, (Object) null);
    }

    public static final DocumentFile getRootDocumentFile(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return getRootDocumentFile$default(documentFile, context, false, 2, (Object) null);
    }

    public static final DocumentFile makeFile(DocumentFile documentFile, Context context, String str) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        return makeFile$default(documentFile, context, str, (String) null, (CreateMode) null, 12, (Object) null);
    }

    public static final DocumentFile makeFile(DocumentFile documentFile, Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        return makeFile$default(documentFile, context, str, str2, (CreateMode) null, 8, (Object) null);
    }

    public static final DocumentFile makeFolder(DocumentFile documentFile, Context context, String str) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        return makeFolder$default(documentFile, context, str, (CreateMode) null, 4, (Object) null);
    }

    public static final void moveFileToDownloadMedia(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback fileCallback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "fileDescription");
        Intrinsics.checkNotNullParameter(fileCallback, "callback");
        moveFileToDownloadMedia$default(documentFile, context, fileDescription, fileCallback, (CreateMode) null, 8, (Object) null);
    }

    public static final void moveFileToPictureMedia(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback fileCallback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "fileDescription");
        Intrinsics.checkNotNullParameter(fileCallback, "callback");
        moveFileToPictureMedia$default(documentFile, context, fileDescription, fileCallback, (CreateMode) null, 8, (Object) null);
    }

    public static final OutputStream openOutputStream(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return openOutputStream$default(documentFile, context, false, 2, (Object) null);
    }

    public static final List<DocumentFile> search(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        return search$default(documentFile, false, (DocumentFileType) null, (String[]) null, (String) null, (Regex) null, 31, (Object) null);
    }

    public static final List<DocumentFile> search(DocumentFile documentFile, boolean z) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        return search$default(documentFile, z, (DocumentFileType) null, (String[]) null, (String) null, (Regex) null, 30, (Object) null);
    }

    public static final List<DocumentFile> search(DocumentFile documentFile, boolean z, DocumentFileType documentFileType) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(documentFileType, "documentType");
        return search$default(documentFile, z, documentFileType, (String[]) null, (String) null, (Regex) null, 28, (Object) null);
    }

    public static final List<DocumentFile> search(DocumentFile documentFile, boolean z, DocumentFileType documentFileType, String[] strArr) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(documentFileType, "documentType");
        return search$default(documentFile, z, documentFileType, strArr, (String) null, (Regex) null, 24, (Object) null);
    }

    public static final List<DocumentFile> search(DocumentFile documentFile, boolean z, DocumentFileType documentFileType, String[] strArr, String str) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(documentFileType, "documentType");
        Intrinsics.checkNotNullParameter(str, "name");
        return search$default(documentFile, z, documentFileType, strArr, str, (Regex) null, 16, (Object) null);
    }

    public static final String getStorageId(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Uri uri = documentFile.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return UriUtils.getStorageId(uri, context);
    }

    public static final boolean isTreeDocumentFile(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Uri uri = documentFile.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return UriUtils.isTreeDocumentFile(uri);
    }

    public static final boolean isExternalStorageDocument(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Uri uri = documentFile.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return UriUtils.isExternalStorageDocument(uri);
    }

    public static final boolean isDownloadsDocument(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Uri uri = documentFile.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return UriUtils.isDownloadsDocument(uri);
    }

    public static final boolean isMediaDocument(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Uri uri = documentFile.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return UriUtils.isMediaDocument(uri);
    }

    public static final boolean isReadOnly(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return documentFile.canRead() && !isWritable(documentFile, context);
    }

    public static final String getId(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        String documentId = DocumentsContract.getDocumentId(documentFile.getUri());
        Intrinsics.checkNotNullExpressionValue(documentId, "getDocumentId(uri)");
        return documentId;
    }

    public static final String getRootId(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        String rootId = DocumentsContract.getRootId(documentFile.getUri());
        Intrinsics.checkNotNullExpressionValue(rootId, "getRootId(uri)");
        return rootId;
    }

    public static final boolean isExternalStorageManager(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isRawFile(documentFile)) {
            String path = documentFile.getUri().getPath();
            Intrinsics.checkNotNull(path);
            if (FileUtils.isExternalStorageManager(new File(path), context)) {
                return true;
            }
        }
        return false;
    }

    public static final String getFullName(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        String str = "";
        if (isRawFile(documentFile) || isExternalStorageDocument(documentFile) || documentFile.isDirectory()) {
            String name = documentFile.getName();
            return name == null ? str : name;
        }
        String name2 = documentFile.getName();
        if (name2 != null) {
            str = name2;
        }
        return MimeType.getFullFileName(str, documentFile.getType());
    }

    public static final boolean inSameMountPointWith(DocumentFile documentFile, Context context, DocumentFile documentFile2) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(documentFile2, "file");
        String storageId = getStorageId(documentFile, context);
        String storageId2 = getStorageId(documentFile2, context);
        return Intrinsics.areEqual((Object) storageId, (Object) storageId2) || ((Intrinsics.areEqual((Object) storageId, (Object) StorageId.PRIMARY) || Intrinsics.areEqual((Object) storageId, (Object) "data")) && (Intrinsics.areEqual((Object) storageId2, (Object) StorageId.PRIMARY) || Intrinsics.areEqual((Object) storageId2, (Object) "data")));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0077, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007b, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007e A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isEmpty(androidx.documentfile.provider.DocumentFile r10, android.content.Context r11) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            boolean r0 = r10.isFile()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001c
            long r3 = r10.length()
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x007e
        L_0x001c:
            boolean r0 = r10.isDirectory()
            if (r0 == 0) goto L_0x007f
            boolean r0 = isRawFile(r10)
            r3 = 0
            if (r0 == 0) goto L_0x0043
            java.io.File r10 = toRawFile(r10, r11)
            if (r10 != 0) goto L_0x0030
            goto L_0x0034
        L_0x0030:
            java.lang.String[] r3 = r10.list()
        L_0x0034:
            if (r3 == 0) goto L_0x0041
            int r10 = r3.length
            if (r10 != 0) goto L_0x003b
            r10 = 1
            goto L_0x003c
        L_0x003b:
            r10 = 0
        L_0x003c:
            if (r10 == 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r11 = 0
            goto L_0x007c
        L_0x0041:
            r11 = 1
            goto L_0x007c
        L_0x0043:
            android.net.Uri r0 = r10.getUri()     // Catch:{ Exception -> 0x0041 }
            java.lang.String r10 = getId(r10)     // Catch:{ Exception -> 0x0041 }
            android.net.Uri r5 = android.provider.DocumentsContract.buildChildDocumentsUriUsingTree(r0, r10)     // Catch:{ Exception -> 0x0041 }
            android.content.ContentResolver r4 = r11.getContentResolver()     // Catch:{ Exception -> 0x0041 }
            java.lang.String r10 = "document_id"
            java.lang.String[] r6 = new java.lang.String[]{r10}     // Catch:{ Exception -> 0x0041 }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r10 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0041 }
            if (r10 != 0) goto L_0x0063
            goto L_0x0041
        L_0x0063:
            java.io.Closeable r10 = (java.io.Closeable) r10     // Catch:{ Exception -> 0x0041 }
            r11 = r10
            android.database.Cursor r11 = (android.database.Cursor) r11     // Catch:{ all -> 0x0075 }
            int r11 = r11.getCount()     // Catch:{ all -> 0x0075 }
            if (r11 != 0) goto L_0x0070
            r11 = 1
            goto L_0x0071
        L_0x0070:
            r11 = 0
        L_0x0071:
            kotlin.io.CloseableKt.closeFinally(r10, r3)     // Catch:{ Exception -> 0x0041 }
            goto L_0x007c
        L_0x0075:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x0077 }
        L_0x0077:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r10, r11)     // Catch:{ Exception -> 0x0041 }
            throw r0     // Catch:{ Exception -> 0x0041 }
        L_0x007c:
            if (r11 == 0) goto L_0x007f
        L_0x007e:
            r1 = 1
        L_0x007f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileUtils.isEmpty(androidx.documentfile.provider.DocumentFile, android.content.Context):boolean");
    }

    public static final void getProperties(DocumentFile documentFile, Context context, FileProperties.CalculationCallback calculationCallback) {
        DocumentFile documentFile2 = documentFile;
        FileProperties.CalculationCallback calculationCallback2 = calculationCallback;
        Intrinsics.checkNotNullParameter(documentFile2, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(calculationCallback2, "callback");
        if (!documentFile.canRead()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(calculationCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$getProperties$$inlined$postToUi$1((Continuation) null, calculationCallback2), 2, (Object) null);
        } else if (documentFile.isDirectory()) {
            String name = documentFile.getName();
            if (name == null) {
                name = "";
            }
            String str = name;
            String absolutePath = getAbsolutePath(documentFile, context);
            boolean isVirtual = documentFile.isVirtual();
            long lastModified = documentFile.lastModified();
            FileProperties fileProperties = new FileProperties(str, absolutePath, 0, true, 0, 0, 0, 0, isVirtual, lastModified > 0 ? new Date(lastModified) : null, 244, (DefaultConstructorMarker) null);
            if (isEmpty(documentFile, context)) {
                Job unused2 = BuildersKt__Builders_commonKt.launch$default(calculationCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$getProperties$$inlined$postToUi$2((Continuation) null, calculationCallback2, fileProperties), 2, (Object) null);
                return;
            }
            Job startCoroutineTimer$default = calculationCallback.getUpdateInterval() < 1 ? null : CoroutineExtKt.startCoroutineTimer$default(0, calculationCallback.getUpdateInterval(), false, new DocumentFileUtils$getProperties$timer$1(calculationCallback2, fileProperties), 5, (Object) null);
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "thread");
            walkFileTreeForInfo(documentFile2, fileProperties, currentThread);
            if (startCoroutineTimer$default != null) {
                Job.DefaultImpls.cancel$default(startCoroutineTimer$default, (CancellationException) null, 1, (Object) null);
            }
            Job unused3 = BuildersKt__Builders_commonKt.launch$default(calculationCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$getProperties$$inlined$postToUi$3((Continuation) null, currentThread.isInterrupted(), calculationCallback2, fileProperties), 2, (Object) null);
        } else if (documentFile.isFile()) {
            String fullName = getFullName(documentFile);
            String absolutePath2 = getAbsolutePath(documentFile, context);
            long length = documentFile.length();
            boolean isVirtual2 = documentFile.isVirtual();
            long lastModified2 = documentFile.lastModified();
            Job unused4 = BuildersKt__Builders_commonKt.launch$default(calculationCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$getProperties$$inlined$postToUi$4((Continuation) null, calculationCallback2, new FileProperties(fullName, absolutePath2, length, false, 0, 0, 0, 0, isVirtual2, lastModified2 > 0 ? new Date(lastModified2) : null, 248, (DefaultConstructorMarker) null)), 2, (Object) null);
        }
    }

    private static final void walkFileTreeForInfo(DocumentFile documentFile, FileProperties fileProperties, Thread thread) {
        DocumentFile[] listFiles = documentFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
        int i = 0;
        if (listFiles.length == 0) {
            fileProperties.setEmptyFolders(fileProperties.getEmptyFolders() + 1);
            return;
        }
        int length = listFiles.length;
        while (i < length) {
            DocumentFile documentFile2 = listFiles[i];
            i++;
            if (!thread.isInterrupted()) {
                if (documentFile2.isFile()) {
                    fileProperties.setFiles(fileProperties.getFiles() + 1);
                    long length2 = documentFile2.length();
                    fileProperties.setSize(fileProperties.getSize() + length2);
                    if (length2 == 0) {
                        fileProperties.setEmptyFiles(fileProperties.getEmptyFiles() + 1);
                    }
                } else {
                    fileProperties.setFolders(fileProperties.getFolders() + 1);
                    Intrinsics.checkNotNullExpressionValue(documentFile2, "it");
                    walkFileTreeForInfo(documentFile2, fileProperties, thread);
                }
            } else {
                return;
            }
        }
    }

    public static final StorageType getStorageType(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isTreeDocumentFile(documentFile)) {
            return inPrimaryStorage(documentFile, context) ? StorageType.EXTERNAL : StorageType.SD_CARD;
        }
        if (inSdCardStorage(documentFile, context)) {
            return StorageType.SD_CARD;
        }
        if (inDataStorage(documentFile, context)) {
            return StorageType.DATA;
        }
        return StorageType.UNKNOWN;
    }

    public static final boolean inInternalStorage(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String storageId = getStorageId(documentFile, context);
        return Intrinsics.areEqual((Object) storageId, (Object) StorageId.PRIMARY) || Intrinsics.areEqual((Object) storageId, (Object) "data");
    }

    public static final boolean inPrimaryStorage(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!isTreeDocumentFile(documentFile) || !Intrinsics.areEqual((Object) getStorageId(documentFile, context), (Object) StorageId.PRIMARY)) {
            if (!isRawFile(documentFile)) {
                return false;
            }
            String path = documentFile.getUri().getPath();
            if (path == null) {
                path = "";
            }
            if (StringsKt.startsWith$default(path, SimpleStorage.Companion.getExternalStoragePath(), false, 2, (Object) null)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static final boolean inSdCardStorage(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!isTreeDocumentFile(documentFile) || Intrinsics.areEqual((Object) getStorageId(documentFile, context), (Object) StorageId.PRIMARY)) {
            if (!isRawFile(documentFile)) {
                return false;
            }
            String path = documentFile.getUri().getPath();
            if (path == null) {
                path = "";
            }
            if (StringsKt.startsWith$default(path, Intrinsics.stringPlus("/storage/", getStorageId(documentFile, context)), false, 2, (Object) null)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static final boolean inDataStorage(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isRawFile(documentFile)) {
            String path = documentFile.getUri().getPath();
            Intrinsics.checkNotNull(path);
            if (FileUtils.inDataStorage(new File(path), context)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isRawFile(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Uri uri = documentFile.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return UriUtils.isRawFile(uri);
    }

    public static final String getBaseName(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        return StringsKt.substringBeforeLast$default(getFullName(documentFile), '.', (String) null, 2, (Object) null);
    }

    public static final String getExtension(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        return StringsKt.substringAfterLast(getFullName(documentFile), '.', "");
    }

    public static final String getMimeType(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        if (!documentFile.isFile()) {
            return null;
        }
        String type = documentFile.getType();
        return type == null ? MimeType.getMimeTypeFromExtension(getExtension(documentFile)) : type;
    }

    public static final String getMimeTypeByFileName(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        if (documentFile.isDirectory()) {
            return null;
        }
        String name = documentFile.getName();
        if (name == null) {
            name = "";
        }
        String mimeTypeFromExtension = MimeType.getMimeTypeFromExtension(StringsKt.substringAfterLast(name, '.', ""));
        return Intrinsics.areEqual((Object) mimeTypeFromExtension, (Object) MimeType.UNKNOWN) ? documentFile.getType() : mimeTypeFromExtension;
    }

    public static final File toRawFile(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isRawFile(documentFile)) {
            String path = documentFile.getUri().getPath();
            if (path == null) {
                return null;
            }
            return new File(path);
        } else if (inPrimaryStorage(documentFile, context)) {
            return new File(SimpleStorage.Companion.getExternalStoragePath() + '/' + getBasePath(documentFile, context));
        } else {
            if (!(getStorageId(documentFile, context).length() > 0)) {
                return null;
            }
            return new File("/storage/" + getStorageId(documentFile, context) + '/' + getBasePath(documentFile, context));
        }
    }

    public static final DocumentFile toRawDocumentFile(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isRawFile(documentFile)) {
            return documentFile;
        }
        File rawFile = toRawFile(documentFile, context);
        if (rawFile == null) {
            return null;
        }
        return DocumentFile.fromFile(rawFile);
    }

    public static final DocumentFile toTreeDocumentFile(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isRawFile(documentFile)) {
            File rawFile = toRawFile(documentFile, context);
            if (rawFile == null) {
                return null;
            }
            return DocumentFileCompat.fromFile$default(context, rawFile, (DocumentFileType) null, false, false, 12, (Object) null);
        } else if (isTreeDocumentFile(documentFile)) {
            return documentFile;
        } else {
            return null;
        }
    }

    public static final MediaFile toMediaFile(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isTreeDocumentFile(documentFile)) {
            return null;
        }
        Uri uri = documentFile.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return new MediaFile(context, uri);
    }

    public static /* synthetic */ DocumentFile child$default(DocumentFile documentFile, Context context, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return child(documentFile, context, str, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.documentfile.provider.DocumentFile child(androidx.documentfile.provider.DocumentFile r4, android.content.Context r5, java.lang.String r6, boolean r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "path"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = r6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x001a
            r0 = 1
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            r1 = 0
            if (r0 == 0) goto L_0x001f
            goto L_0x0069
        L_0x001f:
            boolean r0 = r4.isDirectory()
            if (r0 == 0) goto L_0x0068
            boolean r0 = isRawFile(r4)
            if (r0 == 0) goto L_0x0030
            androidx.documentfile.provider.DocumentFile r4 = quickFindRawFile(r4, r6)
            goto L_0x0060
        L_0x0030:
            android.content.ContentResolver r0 = r5.getContentResolver()
            com.anggrayudi.storage.file.DocumentFileCompat r2 = com.anggrayudi.storage.file.DocumentFileCompat.INSTANCE
            java.util.List r6 = r2.getDirectorySequence$storage_release(r6)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L_0x0040:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L_0x0060
            java.lang.Object r2 = r6.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "resolver"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            androidx.documentfile.provider.DocumentFile r4 = quickFindTreeFile(r4, r5, r0, r2)
            if (r4 != 0) goto L_0x0058
            return r1
        L_0x0058:
            boolean r2 = r4.canRead()
            if (r2 == 0) goto L_0x005f
            goto L_0x0040
        L_0x005f:
            return r1
        L_0x0060:
            if (r4 != 0) goto L_0x0063
            goto L_0x0068
        L_0x0063:
            androidx.documentfile.provider.DocumentFile r4 = takeIfWritable(r4, r5, r7)
            goto L_0x0069
        L_0x0068:
            r4 = r1
        L_0x0069:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileUtils.child(androidx.documentfile.provider.DocumentFile, android.content.Context, java.lang.String, boolean):androidx.documentfile.provider.DocumentFile");
    }

    public static final DocumentFile quickFindRawFile(DocumentFile documentFile, String str) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        String path = documentFile.getUri().getPath();
        Intrinsics.checkNotNull(path);
        DocumentFile fromFile = DocumentFile.fromFile(new File(path, str));
        if (fromFile.canRead()) {
            return fromFile;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008a, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008e, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0097, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x009b, code lost:
        throw r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.documentfile.provider.DocumentFile quickFindTreeFile(androidx.documentfile.provider.DocumentFile r12, android.content.Context r13, android.content.ContentResolver r14, java.lang.String r15) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "resolver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = 0
            android.net.Uri r1 = r12.getUri()     // Catch:{ Exception -> 0x009c }
            java.lang.String r2 = getId(r12)     // Catch:{ Exception -> 0x009c }
            android.net.Uri r4 = android.provider.DocumentsContract.buildChildDocumentsUriUsingTree(r1, r2)     // Catch:{ Exception -> 0x009c }
            java.lang.String r1 = "document_id"
            java.lang.String[] r5 = new java.lang.String[]{r1}     // Catch:{ Exception -> 0x009c }
            r6 = 0
            r7 = 0
            r8 = 0
            r3 = r14
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x009c }
            if (r1 != 0) goto L_0x0032
            goto L_0x009c
        L_0x0032:
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ Exception -> 0x009c }
            r2 = r1
            android.database.Cursor r2 = (android.database.Cursor) r2     // Catch:{ all -> 0x0095 }
            java.lang.String r3 = "_display_name"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ all -> 0x0095 }
        L_0x003d:
            boolean r4 = r2.moveToNext()     // Catch:{ all -> 0x0095 }
            if (r4 == 0) goto L_0x008f
            android.net.Uri r4 = r12.getUri()     // Catch:{ Exception -> 0x003d }
            r10 = 0
            java.lang.String r5 = r2.getString(r10)     // Catch:{ Exception -> 0x003d }
            android.net.Uri r11 = android.provider.DocumentsContract.buildDocumentUriUsingTree(r4, r5)     // Catch:{ Exception -> 0x003d }
            r7 = 0
            r8 = 0
            r9 = 0
            r4 = r14
            r5 = r11
            r6 = r3
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x003d }
            if (r4 != 0) goto L_0x005d
            goto L_0x003d
        L_0x005d:
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ Exception -> 0x003d }
            r5 = r4
            android.database.Cursor r5 = (android.database.Cursor) r5     // Catch:{ all -> 0x0088 }
            boolean r6 = r5.moveToFirst()     // Catch:{ all -> 0x0088 }
            if (r6 == 0) goto L_0x0082
            java.lang.String r5 = r5.getString(r10)     // Catch:{ all -> 0x0088 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r5)     // Catch:{ all -> 0x0088 }
            if (r5 == 0) goto L_0x0082
            java.lang.String r5 = "documentUri"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r5)     // Catch:{ all -> 0x0088 }
            androidx.documentfile.provider.DocumentFile r5 = com.anggrayudi.storage.extension.ContextUtils.fromTreeUri(r13, r11)     // Catch:{ all -> 0x0088 }
            kotlin.io.CloseableKt.closeFinally(r4, r0)     // Catch:{ Exception -> 0x003d }
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ Exception -> 0x009c }
            return r5
        L_0x0082:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0088 }
            kotlin.io.CloseableKt.closeFinally(r4, r0)     // Catch:{ Exception -> 0x003d }
            goto L_0x003d
        L_0x0088:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x008a }
        L_0x008a:
            r6 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r5)     // Catch:{ Exception -> 0x003d }
            throw r6     // Catch:{ Exception -> 0x003d }
        L_0x008f:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0095 }
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ Exception -> 0x009c }
            goto L_0x009c
        L_0x0095:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x0097 }
        L_0x0097:
            r13 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r12)     // Catch:{ Exception -> 0x009c }
            throw r13     // Catch:{ Exception -> 0x009c }
        L_0x009c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileUtils.quickFindTreeFile(androidx.documentfile.provider.DocumentFile, android.content.Context, android.content.ContentResolver, java.lang.String):androidx.documentfile.provider.DocumentFile");
    }

    public static final boolean shouldWritable(DocumentFile documentFile, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return (z && isWritable(documentFile, context)) || !z;
    }

    public static final DocumentFile takeIfWritable(DocumentFile documentFile, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (shouldWritable(documentFile, context, z)) {
            return documentFile;
        }
        return null;
    }

    public static final boolean checkRequirements(DocumentFile documentFile, Context context, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return documentFile.canRead() && (z2 || isExternalStorageManager(documentFile, context)) && shouldWritable(documentFile, context, z);
    }

    public static final String getBasePath(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String path = documentFile.getUri().getPath();
        if (path == null) {
            path = "";
        }
        String storageId = getStorageId(documentFile, context);
        if (isRawFile(documentFile)) {
            return FileUtils.getBasePath(new File(path), context);
        }
        if (isExternalStorageDocument(documentFile)) {
            if (StringsKt.contains$default((CharSequence) path, (CharSequence) "/document/" + storageId + JsonLexerKt.COLON, false, 2, (Object) null)) {
                return TextUtils.trimFileSeparator(StringsKt.substringAfterLast(path, "/document/" + storageId + JsonLexerKt.COLON, ""));
            }
        }
        if (!isDownloadsDocument(documentFile)) {
            return "";
        }
        if (Build.VERSION.SDK_INT < 28) {
            if (new Regex("/document/\\d+").matches(path)) {
                Uri uri = documentFile.getUri();
                Intrinsics.checkNotNullExpressionValue(uri, "uri");
                String name = new MediaFile(context, uri).getName();
                if (name == null) {
                    return "";
                }
                return Environment.DIRECTORY_DOWNLOADS + '/' + name;
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (new Regex("(.*?)/ms[f,d]:\\d+(.*?)").matches(path)) {
                if (!isTreeDocumentFile(documentFile)) {
                    return "";
                }
                String[] strArr = new String[1];
                String name2 = documentFile.getName();
                if (name2 == null) {
                    name2 = "";
                }
                strArr[0] = name2;
                List mutableListOf = CollectionsKt.mutableListOf(strArr);
                while (true) {
                    DocumentFile parentFile = documentFile.getParentFile();
                    if (parentFile == null) {
                        parentFile = null;
                    } else {
                        documentFile = parentFile;
                    }
                    if (parentFile == null) {
                        return CollectionsKt.joinToString$default(CollectionsKt.reversed(mutableListOf), "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                    }
                    String name3 = documentFile.getName();
                    if (name3 == null) {
                        name3 = "";
                    }
                    mutableListOf.add(name3);
                }
            }
        }
        return TextUtils.trimFileSeparator(StringsKt.substringAfterLast(path, SimpleStorage.Companion.getExternalStoragePath(), ""));
    }

    private static final String getSubPath(DocumentFile documentFile, Context context, String str) {
        String absolutePath = getAbsolutePath(documentFile, context);
        if (absolutePath.length() > str.length()) {
            return TextUtils.trimFileSeparator(StringsKt.substringAfter(absolutePath, StringsKt.substringAfterLast$default(str, '/', (String) null, 2, (Object) null), ""));
        }
        if (str.length() > absolutePath.length()) {
            return TextUtils.trimFileSeparator(StringsKt.substringAfter(str, StringsKt.substringAfterLast$default(absolutePath, '/', (String) null, 2, (Object) null), ""));
        }
        return "";
    }

    public static final String getRootPath(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isRawFile(documentFile)) {
            String path = documentFile.getUri().getPath();
            String rootPath = path == null ? null : FileUtils.getRootPath(new File(path), context);
            return rootPath == null ? "" : rootPath;
        } else if (!isTreeDocumentFile(documentFile)) {
            return "";
        } else {
            if (inSdCardStorage(documentFile, context)) {
                return Intrinsics.stringPlus("/storage/", getStorageId(documentFile, context));
            }
            return SimpleStorage.Companion.getExternalStoragePath();
        }
    }

    public static final String getRelativePath(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return StringsKt.substringBeforeLast(getBasePath(documentFile, context), '/', "");
    }

    public static final String getAbsolutePath(DocumentFile documentFile, Context context) {
        String str;
        Context context2 = context;
        DocumentFile documentFile2 = documentFile;
        Intrinsics.checkNotNullParameter(documentFile2, "<this>");
        Intrinsics.checkNotNullParameter(context2, "context");
        String path = documentFile.getUri().getPath();
        String str2 = "";
        if (path == null) {
            path = str2;
        }
        String storageId = getStorageId(documentFile, context);
        if (isRawFile(documentFile)) {
            return path;
        }
        if (isExternalStorageDocument(documentFile)) {
            if (StringsKt.contains$default((CharSequence) path, (CharSequence) "/document/" + storageId + JsonLexerKt.COLON, false, 2, (Object) null)) {
                String trimFileSeparator = TextUtils.trimFileSeparator(StringsKt.substringAfterLast(path, "/document/" + storageId + JsonLexerKt.COLON, str2));
                if (Intrinsics.areEqual((Object) storageId, (Object) StorageId.PRIMARY)) {
                    return StringsKt.trimEnd(SimpleStorage.Companion.getExternalStoragePath() + '/' + trimFileSeparator, '/');
                }
                return StringsKt.trimEnd("/storage/" + storageId + '/' + trimFileSeparator, '/');
            }
        }
        String uri = documentFile.getUri().toString();
        if (Intrinsics.areEqual((Object) uri, (Object) DocumentFileCompat.DOWNLOADS_TREE_URI) || Intrinsics.areEqual((Object) uri, (Object) "content://com.android.providers.downloads.documents/tree/downloads/document/downloads")) {
            String absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getExternalStoragePublic…Y_DOWNLOADS).absolutePath");
            return absolutePath;
        } else if (isDownloadsDocument(documentFile)) {
            if (Build.VERSION.SDK_INT < 28) {
                if (new Regex("/document/\\d+").matches(path)) {
                    Uri uri2 = documentFile.getUri();
                    Intrinsics.checkNotNullExpressionValue(uri2, "uri");
                    String name = new MediaFile(context2, uri2).getName();
                    if (name == null) {
                        return str2;
                    }
                    str = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), name).getAbsolutePath();
                    str2 = str;
                    Intrinsics.checkNotNullExpressionValue(str2, "{\n            when {\n   …)\n            }\n        }");
                    return str2;
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                if (new Regex("(.*?)/ms[f,d]:\\d+(.*?)").matches(path)) {
                    if (isTreeDocumentFile(documentFile)) {
                        String[] strArr = new String[1];
                        String name2 = documentFile.getName();
                        if (name2 == null) {
                            name2 = str2;
                        }
                        strArr[0] = name2;
                        List mutableListOf = CollectionsKt.mutableListOf(strArr);
                        while (true) {
                            DocumentFile parentFile = documentFile2.getParentFile();
                            if (parentFile == null) {
                                parentFile = null;
                            } else {
                                documentFile2 = parentFile;
                            }
                            if (parentFile == null) {
                                break;
                            }
                            String name3 = documentFile2.getName();
                            if (name3 == null) {
                                name3 = str2;
                            }
                            mutableListOf.add(name3);
                        }
                        str = StringsKt.trimEnd(SimpleStorage.Companion.getExternalStoragePath() + '/' + CollectionsKt.joinToString$default(CollectionsKt.reversed(mutableListOf), "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), '/');
                        str2 = str;
                    }
                    Intrinsics.checkNotNullExpressionValue(str2, "{\n            when {\n   …)\n            }\n        }");
                    return str2;
                }
            }
            str = StringsKt.trimEnd(StringsKt.substringAfterLast(path, "/document/raw:", str2), '/');
            str2 = str;
            Intrinsics.checkNotNullExpressionValue(str2, "{\n            when {\n   …)\n            }\n        }");
            return str2;
        } else if (!isTreeDocumentFile(documentFile)) {
            return str2;
        } else {
            if (inPrimaryStorage(documentFile, context)) {
                return StringsKt.trimEnd(SimpleStorage.Companion.getExternalStoragePath() + '/' + getBasePath(documentFile, context), '/');
            }
            return StringsKt.trimEnd("/storage/" + storageId + '/' + getBasePath(documentFile, context), '/');
        }
    }

    public static final String getSimplePath(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return StringsKt.removePrefix(getStorageId(documentFile, context) + JsonLexerKt.COLON + getBasePath(documentFile, context), (CharSequence) CertificateUtil.DELIMITER);
    }

    public static final DocumentFile recreateFile(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!documentFile.exists()) {
            return null;
        }
        if (!isRawFile(documentFile) && !isExternalStorageDocument(documentFile)) {
            return null;
        }
        String name = documentFile.getName();
        if (name == null) {
            name = "";
        }
        String str = name;
        DocumentFile parentFile = documentFile.getParentFile();
        boolean z = true;
        if (parentFile == null || !isWritable(parentFile, context)) {
            z = false;
        }
        if (!z) {
            return null;
        }
        String type = documentFile.getType();
        forceDelete$default(documentFile, context, false, 2, (Object) null);
        return makeFile$default(parentFile, context, str, type, (CreateMode) null, 8, (Object) null);
    }

    public static /* synthetic */ DocumentFile getRootDocumentFile$default(DocumentFile documentFile, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return getRootDocumentFile(documentFile, context, z);
    }

    public static final DocumentFile getRootDocumentFile(DocumentFile documentFile, Context context, boolean z) {
        String path;
        File rootRawFile;
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isTreeDocumentFile(documentFile)) {
            return DocumentFileCompat.getRootDocumentFile$default(context, getStorageId(documentFile, context), z, false, 8, (Object) null);
        } else if (!isRawFile(documentFile) || (path = documentFile.getUri().getPath()) == null || (rootRawFile = FileUtils.getRootRawFile(new File(path), context, z)) == null) {
            return null;
        } else {
            return DocumentFile.fromFile(rootRawFile);
        }
    }

    public static final boolean canModify(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return documentFile.canRead() && isWritable(documentFile, context);
    }

    public static final boolean isWritable(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!isRawFile(documentFile)) {
            return documentFile.canWrite();
        }
        String path = documentFile.getUri().getPath();
        Intrinsics.checkNotNull(path);
        return FileUtils.isWritable(new File(path), context);
    }

    public static final boolean isRootUriPermissionGranted(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return isExternalStorageDocument(documentFile) && DocumentFileCompat.isStorageUriPermissionGranted$default(context, getStorageId(documentFile, context), (String) null, 4, (Object) null);
    }

    public static final String getFormattedSize(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return Formatter.formatFileSize(context, documentFile.length());
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00a5 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String autoIncrementFileName(androidx.documentfile.provider.DocumentFile r17, android.content.Context r18, java.lang.String r19) {
        /*
            r0 = r19
            java.lang.String r1 = "<this>"
            r2 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.lang.String r1 = "context"
            r3 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            java.lang.String r1 = "filename"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.io.File r1 = toRawFile(r17, r18)
            if (r1 != 0) goto L_0x001c
            goto L_0x0027
        L_0x001c:
            boolean r3 = r1.canRead()
            if (r3 == 0) goto L_0x0027
            java.lang.String r0 = com.anggrayudi.storage.file.FileUtils.autoIncrementFileName(r1, r0)
            return r0
        L_0x0027:
            androidx.documentfile.provider.DocumentFile[] r1 = r17.listFiles()
            java.lang.String r2 = "listFiles()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x0033:
            r5 = 0
            if (r4 >= r2) goto L_0x0045
            r6 = r1[r4]
            int r4 = r4 + 1
            java.lang.String r7 = r6.getName()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            if (r7 == 0) goto L_0x0033
            goto L_0x0046
        L_0x0045:
            r6 = r5
        L_0x0046:
            r2 = 1
            if (r6 != 0) goto L_0x004b
        L_0x0049:
            r4 = 0
            goto L_0x0052
        L_0x004b:
            boolean r4 = r6.exists()
            if (r4 != r2) goto L_0x0049
            r4 = 1
        L_0x0052:
            if (r4 == 0) goto L_0x0144
            r4 = 46
            r6 = 2
            java.lang.String r7 = kotlin.text.StringsKt.substringBeforeLast$default((java.lang.String) r0, (char) r4, (java.lang.String) r5, (int) r6, (java.lang.Object) r5)
            java.lang.String r8 = ""
            java.lang.String r0 = kotlin.text.StringsKt.substringAfterLast((java.lang.String) r0, (char) r4, (java.lang.String) r8)
            java.lang.String r9 = " ("
            java.lang.String r10 = kotlin.jvm.internal.Intrinsics.stringPlus(r7, r9)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Collection r11 = (java.util.Collection) r11
            int r12 = r1.length
            r13 = 0
        L_0x0070:
            if (r13 >= r12) goto L_0x00a7
            r14 = r1[r13]
            int r13 = r13 + 1
            java.lang.String r15 = r14.getName()
            if (r15 != 0) goto L_0x007d
            r15 = r8
        L_0x007d:
            boolean r16 = kotlin.text.StringsKt.startsWith$default(r15, r10, r3, r6, r5)
            if (r16 == 0) goto L_0x009f
            com.anggrayudi.storage.file.DocumentFileCompat r16 = com.anggrayudi.storage.file.DocumentFileCompat.INSTANCE
            kotlin.text.Regex r5 = r16.getFILE_NAME_DUPLICATION_REGEX_WITH_EXTENSION()
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r5 = r5.matches(r15)
            if (r5 != 0) goto L_0x009d
            com.anggrayudi.storage.file.DocumentFileCompat r5 = com.anggrayudi.storage.file.DocumentFileCompat.INSTANCE
            kotlin.text.Regex r5 = r5.getFILE_NAME_DUPLICATION_REGEX_WITHOUT_EXTENSION()
            boolean r5 = r5.matches(r15)
            if (r5 == 0) goto L_0x009f
        L_0x009d:
            r5 = 1
            goto L_0x00a0
        L_0x009f:
            r5 = 0
        L_0x00a0:
            if (r5 == 0) goto L_0x00a5
            r11.add(r14)
        L_0x00a5:
            r5 = 0
            goto L_0x0070
        L_0x00a7:
            java.util.List r11 = (java.util.List) r11
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r1 = r11.iterator()
            boolean r5 = r1.hasNext()
            if (r5 != 0) goto L_0x00b7
            r5 = 0
            goto L_0x0117
        L_0x00b7:
            java.lang.Object r5 = r1.next()
            androidx.documentfile.provider.DocumentFile r5 = (androidx.documentfile.provider.DocumentFile) r5
            java.lang.String r5 = r5.getName()
            if (r5 != 0) goto L_0x00c4
            r5 = r8
        L_0x00c4:
            r6 = 40
            java.lang.String r5 = kotlin.text.StringsKt.substringAfterLast((java.lang.String) r5, (char) r6, (java.lang.String) r8)
            r10 = 41
            java.lang.String r5 = kotlin.text.StringsKt.substringBefore((java.lang.String) r5, (char) r10, (java.lang.String) r8)
            java.lang.Integer r5 = kotlin.text.StringsKt.toIntOrNull(r5)
            if (r5 != 0) goto L_0x00d8
            r5 = 0
            goto L_0x00dc
        L_0x00d8:
            int r5 = r5.intValue()
        L_0x00dc:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Comparable r5 = (java.lang.Comparable) r5
        L_0x00e2:
            boolean r11 = r1.hasNext()
            if (r11 == 0) goto L_0x0117
            java.lang.Object r11 = r1.next()
            androidx.documentfile.provider.DocumentFile r11 = (androidx.documentfile.provider.DocumentFile) r11
            java.lang.String r11 = r11.getName()
            if (r11 != 0) goto L_0x00f5
            r11 = r8
        L_0x00f5:
            java.lang.String r11 = kotlin.text.StringsKt.substringAfterLast((java.lang.String) r11, (char) r6, (java.lang.String) r8)
            java.lang.String r11 = kotlin.text.StringsKt.substringBefore((java.lang.String) r11, (char) r10, (java.lang.String) r8)
            java.lang.Integer r11 = kotlin.text.StringsKt.toIntOrNull(r11)
            if (r11 != 0) goto L_0x0105
            r11 = 0
            goto L_0x0109
        L_0x0105:
            int r11 = r11.intValue()
        L_0x0109:
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            java.lang.Comparable r11 = (java.lang.Comparable) r11
            int r12 = r5.compareTo(r11)
            if (r12 >= 0) goto L_0x00e2
            r5 = r11
            goto L_0x00e2
        L_0x0117:
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 != 0) goto L_0x011d
            r1 = 0
            goto L_0x0121
        L_0x011d:
            int r1 = r5.intValue()
        L_0x0121:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r7)
            r5.append(r9)
            int r1 = r1 + r2
            r5.append(r1)
            java.lang.String r1 = ")."
            r5.append(r1)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            char[] r1 = new char[r2]
            r1[r3] = r4
            java.lang.String r0 = kotlin.text.StringsKt.trimEnd((java.lang.String) r0, (char[]) r1)
        L_0x0144:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileUtils.autoIncrementFileName(androidx.documentfile.provider.DocumentFile, android.content.Context, java.lang.String):java.lang.String");
    }

    public static /* synthetic */ DocumentFile createBinaryFile$default(DocumentFile documentFile, Context context, String str, CreateMode createMode, int i, Object obj) {
        if ((i & 4) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        return createBinaryFile(documentFile, context, str, createMode);
    }

    public static final DocumentFile createBinaryFile(DocumentFile documentFile, Context context, String str, CreateMode createMode) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(createMode, "mode");
        return makeFile(documentFile, context, str, "application/octet-stream", createMode);
    }

    public static /* synthetic */ DocumentFile makeFile$default(DocumentFile documentFile, Context context, String str, String str2, CreateMode createMode, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = MimeType.UNKNOWN;
        }
        if ((i & 8) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        return makeFile(documentFile, context, str, str2, createMode);
    }

    public static final DocumentFile makeFile(DocumentFile documentFile, Context context, String str, String str2, CreateMode createMode) {
        DocumentFile documentFile2;
        String str3;
        String str4;
        DocumentFile documentFile3 = documentFile;
        Context context2 = context;
        String str5 = str;
        String str6 = str2;
        CreateMode createMode2 = createMode;
        Intrinsics.checkNotNullParameter(documentFile3, "<this>");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str5, "name");
        Intrinsics.checkNotNullParameter(createMode2, "mode");
        if (!documentFile.isDirectory() || !isWritable(documentFile, context)) {
            return null;
        }
        String trimFileSeparator = TextUtils.trimFileSeparator(DocumentFileCompat.INSTANCE.removeForbiddenCharsFromFilename$storage_release(str5));
        String substringBeforeLast = StringsKt.substringBeforeLast(trimFileSeparator, '/', "");
        if (substringBeforeLast.length() == 0) {
            documentFile2 = documentFile3;
        } else {
            DocumentFile makeFolder = makeFolder(documentFile3, context2, substringBeforeLast, createMode2);
            if (makeFolder == null) {
                return null;
            }
            documentFile2 = makeFolder;
        }
        String substringAfterLast$default = StringsKt.substringAfterLast$default(trimFileSeparator, '/', (String) null, 2, (Object) null);
        String substringAfterLast = StringsKt.substringAfterLast(trimFileSeparator, '.', "");
        if (!(substringAfterLast.length() > 0) || (str6 != null && !Intrinsics.areEqual((Object) str6, (Object) MimeType.UNKNOWN) && !Intrinsics.areEqual((Object) str6, (Object) "application/octet-stream"))) {
            substringAfterLast = MimeType.getExtensionFromMimeTypeOrFileName(str6, trimFileSeparator);
        }
        String str7 = substringAfterLast;
        String removeSuffix = StringsKt.removeSuffix(substringAfterLast$default, (CharSequence) Intrinsics.stringPlus(".", str7));
        String trimEnd = StringsKt.trimEnd(removeSuffix + '.' + str7, '.');
        if (createMode2 != CreateMode.CREATE_NEW) {
            str4 = removeSuffix;
            str3 = trimEnd;
            DocumentFile child$default = child$default(documentFile2, context, trimEnd, false, 4, (Object) null);
            if (child$default != null) {
                if (createMode2 == CreateMode.REPLACE) {
                    recreateFile(child$default, context2);
                } else {
                    boolean isFile = child$default.isFile();
                }
            }
        } else {
            str4 = removeSuffix;
            str3 = trimEnd;
        }
        if (isRawFile(documentFile)) {
            File rawFile = toRawFile(documentFile, context);
            File makeFile = rawFile == null ? null : FileUtils.makeFile(rawFile, context2, trimFileSeparator, str6, createMode2);
            if (makeFile == null) {
                return null;
            }
            return DocumentFile.fromFile(makeFile);
        }
        String mimeTypeFromExtension = MimeType.getMimeTypeFromExtension(str7);
        if (Intrinsics.areEqual((Object) mimeTypeFromExtension, (Object) MimeType.UNKNOWN)) {
            mimeTypeFromExtension = "application/octet-stream";
        }
        if (Build.VERSION.SDK_INT <= 28) {
            return documentFile2.createFile(mimeTypeFromExtension, str3);
        }
        DocumentFile createFile = documentFile2.createFile(mimeTypeFromExtension, str4);
        if (createFile == null) {
            return null;
        }
        if (Intrinsics.areEqual((Object) mimeTypeFromExtension, (Object) "application/octet-stream")) {
            String str8 = str3;
            if (!Intrinsics.areEqual((Object) createFile.getName(), (Object) str8)) {
                createFile.renameTo(str8);
            }
        }
        return createFile;
    }

    public static /* synthetic */ DocumentFile makeFolder$default(DocumentFile documentFile, Context context, String str, CreateMode createMode, int i, Object obj) {
        if ((i & 4) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        return makeFolder(documentFile, context, str, createMode);
    }

    public static final DocumentFile makeFolder(DocumentFile documentFile, Context context, String str, CreateMode createMode) {
        DocumentFile documentFile2;
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(createMode, "mode");
        if (!documentFile.isDirectory() || !isWritable(documentFile, context)) {
            return null;
        }
        if (isRawFile(documentFile)) {
            File rawFile = toRawFile(documentFile, context);
            File makeFolder = rawFile == null ? null : FileUtils.makeFolder(rawFile, context, str, createMode);
            if (makeFolder == null) {
                return null;
            }
            return DocumentFile.fromFile(makeFolder);
        }
        List<String> mutableList = CollectionsKt.toMutableList(DocumentFileCompat.INSTANCE.getDirectorySequence$storage_release(DocumentFileCompat.INSTANCE.removeForbiddenCharsFromFilename$storage_release(str)));
        String str2 = (String) CollectionsKt.removeFirstOrNull(mutableList);
        if (str2 == null) {
            return null;
        }
        if (isDownloadsDocument(documentFile) && isTreeDocumentFile(documentFile) && (documentFile = toWritableDownloadsDocumentFile(documentFile, context)) == null) {
            return null;
        }
        DocumentFile child$default = child$default(documentFile, context, str2, false, 4, (Object) null);
        if (child$default == null || createMode == CreateMode.CREATE_NEW) {
            child$default = documentFile.createDirectory(str2);
            if (child$default == null) {
                return null;
            }
        } else if (createMode == CreateMode.REPLACE) {
            forceDelete(child$default, context, true);
            if (!child$default.isDirectory() && (child$default = documentFile.createDirectory(str2)) == null) {
                return null;
            }
        } else if (!child$default.isDirectory() || !child$default.canRead()) {
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        for (String str3 : mutableList) {
            try {
                Intrinsics.checkNotNullExpressionValue(contentResolver, "resolver");
                DocumentFile quickFindTreeFile = quickFindTreeFile(documentFile2, context, contentResolver, str3);
                if (quickFindTreeFile == null) {
                    DocumentFile createDirectory = documentFile2.createDirectory(str3);
                    if (createDirectory == null) {
                        return null;
                    }
                    documentFile2 = createDirectory;
                } else {
                    if (quickFindTreeFile.isDirectory() && quickFindTreeFile.canRead()) {
                        documentFile2 = quickFindTreeFile;
                    }
                    return null;
                }
            } catch (Exception unused) {
            }
        }
        return documentFile2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a2, code lost:
        if (new kotlin.text.Regex("/tree/downloads/document/ms[f,d]:\\d+").matches(r0) == false) goto L_0x00a4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.documentfile.provider.DocumentFile toWritableDownloadsDocumentFile(androidx.documentfile.provider.DocumentFile r12, android.content.Context r13) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            boolean r0 = isDownloadsDocument(r12)
            r7 = 0
            if (r0 == 0) goto L_0x00cd
            android.net.Uri r0 = r12.getUri()
            java.lang.String r0 = r0.getPath()
            java.lang.String r8 = ""
            if (r0 != 0) goto L_0x001f
            r9 = r8
            goto L_0x0020
        L_0x001f:
            r9 = r0
        L_0x0020:
            android.net.Uri r0 = r12.getUri()
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "content://com.android.providers.downloads.documents/tree/downloads/document/downloads"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x0038
            boolean r0 = isWritable(r12, r13)
            if (r0 == 0) goto L_0x00d1
            goto L_0x00cb
        L_0x0038:
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r2 = "/tree/downloads/document/raw:"
            r3 = 29
            r4 = 0
            r10 = 2
            if (r0 < r3) goto L_0x0076
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r9, r2, r4, r10, r7)
            java.lang.String r11 = "/document/raw:"
            if (r0 != 0) goto L_0x0050
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r9, r11, r4, r10, r7)
            if (r0 == 0) goto L_0x0076
        L_0x0050:
            com.anggrayudi.storage.file.PublicDirectory r1 = com.anggrayudi.storage.file.PublicDirectory.DOWNLOADS
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 12
            r6 = 0
            r0 = r13
            androidx.documentfile.provider.DocumentFile r0 = com.anggrayudi.storage.file.DocumentFileCompat.fromPublicFolder$default(r0, r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x0060
            return r7
        L_0x0060:
            java.lang.String r1 = kotlin.text.StringsKt.substringAfterLast$default((java.lang.String) r9, (java.lang.String) r11, (java.lang.String) r7, (int) r10, (java.lang.Object) r7)
            java.lang.String r2 = android.os.Environment.DIRECTORY_DOWNLOADS
            java.lang.String r3 = "/"
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r2)
            java.lang.String r1 = kotlin.text.StringsKt.substringAfter((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r8)
            r2 = 1
            androidx.documentfile.provider.DocumentFile r0 = child(r0, r13, r1, r2)
            goto L_0x00d0
        L_0x0076:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r3) goto L_0x00a4
            r0 = r9
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            kotlin.text.Regex r5 = new kotlin.text.Regex
            java.lang.String r6 = "/document/ms[f,d]:\\d+"
            r5.<init>((java.lang.String) r6)
            boolean r5 = r5.matches(r0)
            if (r5 != 0) goto L_0x00c5
            kotlin.text.Regex r5 = new kotlin.text.Regex
            java.lang.String r6 = "/tree/ms[f,d]:\\d+(.*?)"
            r5.<init>((java.lang.String) r6)
            boolean r5 = r5.matches(r0)
            if (r5 != 0) goto L_0x00c5
            kotlin.text.Regex r5 = new kotlin.text.Regex
            java.lang.String r6 = "/tree/downloads/document/ms[f,d]:\\d+"
            r5.<init>((java.lang.String) r6)
            boolean r0 = r5.matches(r0)
            if (r0 != 0) goto L_0x00c5
        L_0x00a4:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 >= r3) goto L_0x00d1
            java.lang.String r0 = "/tree/raw:"
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r9, r0, r4, r10, r7)
            if (r0 != 0) goto L_0x00c5
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r9, r2, r4, r10, r7)
            if (r0 != 0) goto L_0x00c5
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            kotlin.text.Regex r0 = new kotlin.text.Regex
            java.lang.String r2 = "/document/\\d+"
            r0.<init>((java.lang.String) r2)
            boolean r0 = r0.matches(r9)
            if (r0 == 0) goto L_0x00d1
        L_0x00c5:
            boolean r0 = isWritable(r12, r13)
            if (r0 == 0) goto L_0x00d1
        L_0x00cb:
            r7 = r12
            goto L_0x00d1
        L_0x00cd:
            r0 = r7
            androidx.documentfile.provider.DocumentFile r0 = (androidx.documentfile.provider.DocumentFile) r0
        L_0x00d0:
            r7 = r0
        L_0x00d1:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileUtils.toWritableDownloadsDocumentFile(androidx.documentfile.provider.DocumentFile, android.content.Context):androidx.documentfile.provider.DocumentFile");
    }

    public static /* synthetic */ List findFiles$default(DocumentFile documentFile, String[] strArr, DocumentFileType documentFileType, int i, Object obj) {
        if ((i & 2) != 0) {
            documentFileType = DocumentFileType.ANY;
        }
        return findFiles(documentFile, strArr, documentFileType);
    }

    public static final List<DocumentFile> findFiles(DocumentFile documentFile, String[] strArr, DocumentFileType documentFileType) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(strArr, "names");
        Intrinsics.checkNotNullParameter(documentFileType, "documentType");
        DocumentFile[] listFiles = documentFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
        Object[] objArr = (Object[]) listFiles;
        Collection arrayList = new ArrayList();
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            if (ArraysKt.contains((T[]) strArr, ((DocumentFile) obj).getName())) {
                arrayList.add(obj);
            }
        }
        List<DocumentFile> list = (List) arrayList;
        int i2 = WhenMappings.$EnumSwitchMapping$0[documentFileType.ordinal()];
        if (i2 == 1) {
            Collection arrayList2 = new ArrayList();
            for (Object next : list) {
                if (((DocumentFile) next).isFile()) {
                    arrayList2.add(next);
                }
            }
            return (List) arrayList2;
        } else if (i2 != 2) {
            return list;
        } else {
            Collection arrayList3 = new ArrayList();
            for (Object next2 : list) {
                if (((DocumentFile) next2).isDirectory()) {
                    arrayList3.add(next2);
                }
            }
            return (List) arrayList3;
        }
    }

    public static final DocumentFile findFolder(DocumentFile documentFile, String str) {
        DocumentFile documentFile2;
        boolean z;
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        DocumentFile[] listFiles = documentFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
        Object[] objArr = (Object[]) listFiles;
        int length = objArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                documentFile2 = null;
                break;
            }
            documentFile2 = objArr[i];
            i++;
            DocumentFile documentFile3 = (DocumentFile) documentFile2;
            if (!Intrinsics.areEqual((Object) documentFile3.getName(), (Object) str) || !documentFile3.isDirectory()) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        return documentFile2;
    }

    public static final DocumentFile findFileLiterally(DocumentFile documentFile, String str) {
        DocumentFile documentFile2;
        boolean z;
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        DocumentFile[] listFiles = documentFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
        Object[] objArr = (Object[]) listFiles;
        int length = objArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                documentFile2 = null;
                break;
            }
            documentFile2 = objArr[i];
            i++;
            DocumentFile documentFile3 = (DocumentFile) documentFile2;
            if (!Intrinsics.areEqual((Object) documentFile3.getName(), (Object) str) || !documentFile3.isFile()) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        return documentFile2;
    }

    public static /* synthetic */ List search$default(DocumentFile documentFile, boolean z, DocumentFileType documentFileType, String[] strArr, String str, Regex regex, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            documentFileType = DocumentFileType.ANY;
        }
        DocumentFileType documentFileType2 = documentFileType;
        Regex regex2 = null;
        String[] strArr2 = (i & 4) != 0 ? null : strArr;
        if ((i & 8) != 0) {
            str = "";
        }
        String str2 = str;
        if ((i & 16) == 0) {
            regex2 = regex;
        }
        return search(documentFile, z, documentFileType2, strArr2, str2, regex2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<androidx.documentfile.provider.DocumentFile> search(androidx.documentfile.provider.DocumentFile r9, boolean r10, com.anggrayudi.storage.file.DocumentFileType r11, java.lang.String[] r12, java.lang.String r13, kotlin.text.Regex r14) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "documentType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            boolean r0 = r9.isDirectory()
            if (r0 == 0) goto L_0x0120
            boolean r0 = r9.canRead()
            if (r0 != 0) goto L_0x001d
            goto L_0x0120
        L_0x001d:
            java.lang.String r0 = "*/*"
            r1 = 1
            r2 = 0
            if (r10 == 0) goto L_0x006a
            java.lang.Thread r8 = java.lang.Thread.currentThread()
            if (r12 == 0) goto L_0x0034
            int r10 = r12.length
            if (r10 != 0) goto L_0x002e
            r10 = 1
            goto L_0x002f
        L_0x002e:
            r10 = 0
        L_0x002f:
            if (r10 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r10 = 0
            goto L_0x0035
        L_0x0034:
            r10 = 1
        L_0x0035:
            java.lang.String r3 = "thread"
            if (r10 != 0) goto L_0x005b
            int r10 = r12.length
            r4 = 0
        L_0x003b:
            if (r4 >= r10) goto L_0x0048
            r5 = r12[r4]
            int r4 = r4 + 1
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r0)
            if (r5 == 0) goto L_0x003b
            goto L_0x0049
        L_0x0048:
            r1 = 0
        L_0x0049:
            if (r1 == 0) goto L_0x004c
            goto L_0x005b
        L_0x004c:
            com.anggrayudi.storage.file.DocumentFileType r4 = com.anggrayudi.storage.file.DocumentFileType.FILE
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
            r3 = r9
            r5 = r12
            r6 = r13
            r7 = r14
            java.util.List r9 = walkFileTreeForSearch(r3, r4, r5, r6, r7, r8)
            goto L_0x0124
        L_0x005b:
            java.lang.String[] r5 = new java.lang.String[r2]
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
            r3 = r9
            r4 = r11
            r6 = r13
            r7 = r14
            java.util.List r9 = walkFileTreeForSearch(r3, r4, r5, r6, r7, r8)
            goto L_0x0124
        L_0x006a:
            androidx.documentfile.provider.DocumentFile[] r9 = r9.listFiles()
            java.lang.String r10 = "listFiles()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            kotlin.sequences.Sequence r9 = kotlin.collections.ArraysKt.asSequence((T[]) r9)
            com.anggrayudi.storage.file.DocumentFileUtils$search$sequence$1 r10 = com.anggrayudi.storage.file.DocumentFileUtils$search$sequence$1.INSTANCE
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            kotlin.sequences.Sequence r9 = kotlin.sequences.SequencesKt.filter(r9, r10)
            if (r14 == 0) goto L_0x008e
            com.anggrayudi.storage.file.DocumentFileUtils$search$2 r10 = new com.anggrayudi.storage.file.DocumentFileUtils$search$2
            r10.<init>(r14)
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            kotlin.sequences.Sequence r9 = kotlin.sequences.SequencesKt.filter(r9, r10)
        L_0x008e:
            if (r12 == 0) goto L_0x009b
            int r10 = r12.length
            if (r10 != 0) goto L_0x0095
            r10 = 1
            goto L_0x0096
        L_0x0095:
            r10 = 0
        L_0x0096:
            if (r10 == 0) goto L_0x0099
            goto L_0x009b
        L_0x0099:
            r10 = 0
            goto L_0x009c
        L_0x009b:
            r10 = 1
        L_0x009c:
            if (r10 != 0) goto L_0x00b3
            int r10 = r12.length
            r14 = 0
        L_0x00a0:
            if (r14 >= r10) goto L_0x00ae
            r3 = r12[r14]
            int r14 = r14 + 1
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            if (r3 == 0) goto L_0x00a0
            r10 = 1
            goto L_0x00af
        L_0x00ae:
            r10 = 0
        L_0x00af:
            if (r10 != 0) goto L_0x00b3
            r10 = 1
            goto L_0x00b4
        L_0x00b3:
            r10 = 0
        L_0x00b4:
            if (r10 != 0) goto L_0x00c8
            com.anggrayudi.storage.file.DocumentFileType r14 = com.anggrayudi.storage.file.DocumentFileType.FILE
            if (r11 != r14) goto L_0x00bb
            goto L_0x00c8
        L_0x00bb:
            com.anggrayudi.storage.file.DocumentFileType r14 = com.anggrayudi.storage.file.DocumentFileType.FOLDER
            if (r11 != r14) goto L_0x00d0
            com.anggrayudi.storage.file.DocumentFileUtils$search$4 r11 = com.anggrayudi.storage.file.DocumentFileUtils$search$4.INSTANCE
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            kotlin.sequences.Sequence r9 = kotlin.sequences.SequencesKt.filter(r9, r11)
            goto L_0x00d0
        L_0x00c8:
            com.anggrayudi.storage.file.DocumentFileUtils$search$3 r11 = com.anggrayudi.storage.file.DocumentFileUtils$search$3.INSTANCE
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            kotlin.sequences.Sequence r9 = kotlin.sequences.SequencesKt.filter(r9, r11)
        L_0x00d0:
            if (r10 == 0) goto L_0x00dd
            com.anggrayudi.storage.file.DocumentFileUtils$search$5 r10 = new com.anggrayudi.storage.file.DocumentFileUtils$search$5
            r10.<init>(r12)
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            kotlin.sequences.Sequence r9 = kotlin.sequences.SequencesKt.filter(r9, r10)
        L_0x00dd:
            java.util.List r9 = kotlin.sequences.SequencesKt.toList(r9)
            r10 = r13
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            int r10 = r10.length()
            if (r10 != 0) goto L_0x00eb
            goto L_0x00ec
        L_0x00eb:
            r1 = 0
        L_0x00ec:
            if (r1 == 0) goto L_0x00ef
            goto L_0x0124
        L_0x00ef:
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x00f5:
            boolean r10 = r9.hasNext()
            r11 = 0
            if (r10 == 0) goto L_0x010e
            java.lang.Object r10 = r9.next()
            r12 = r10
            androidx.documentfile.provider.DocumentFile r12 = (androidx.documentfile.provider.DocumentFile) r12
            java.lang.String r12 = r12.getName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r12 == 0) goto L_0x00f5
            goto L_0x010f
        L_0x010e:
            r10 = r11
        L_0x010f:
            androidx.documentfile.provider.DocumentFile r10 = (androidx.documentfile.provider.DocumentFile) r10
            if (r10 != 0) goto L_0x0115
            r9 = r11
            goto L_0x0119
        L_0x0115:
            java.util.List r9 = kotlin.collections.CollectionsKt.listOf(r10)
        L_0x0119:
            if (r9 != 0) goto L_0x0124
            java.util.List r9 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0124
        L_0x0120:
            java.util.List r9 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0124:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileUtils.search(androidx.documentfile.provider.DocumentFile, boolean, com.anggrayudi.storage.file.DocumentFileType, java.lang.String[], java.lang.String, kotlin.text.Regex):java.util.List");
    }

    /* access modifiers changed from: private */
    public static final boolean matchesMimeTypes(DocumentFile documentFile, String[] strArr) {
        if (strArr.length == 0) {
            return true;
        }
        CharSequence matches = MimeTypeFilter.matches(getMimeTypeByFileName(documentFile), strArr);
        return !(matches == null || matches.length() == 0);
    }

    private static final List<DocumentFile> walkFileTreeForSearch(DocumentFile documentFile, DocumentFileType documentFileType, String[] strArr, String str, Regex regex, Thread thread) {
        DocumentFileType documentFileType2 = documentFileType;
        String str2 = str;
        Regex regex2 = regex;
        List<DocumentFile> arrayList = new ArrayList<>();
        DocumentFile[] listFiles = documentFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            DocumentFile documentFile2 = listFiles[i];
            int i2 = i + 1;
            if (thread.isInterrupted()) {
                break;
            }
            if (documentFile.canRead()) {
                String str3 = "";
                boolean z = true;
                if (!documentFile2.isFile()) {
                    String[] strArr2 = strArr;
                    if (documentFileType2 != DocumentFileType.FILE) {
                        String name = documentFile2.getName();
                        if (name != null) {
                            str3 = name;
                        }
                        if (str2.length() != 0) {
                            z = false;
                        }
                        if ((z || Intrinsics.areEqual((Object) str3, (Object) str2)) && (regex2 == null || regex2.matches(str3))) {
                            Intrinsics.checkNotNullExpressionValue(documentFile2, "file");
                            arrayList.add(documentFile2);
                        }
                    }
                    Intrinsics.checkNotNullExpressionValue(documentFile2, "file");
                    arrayList.addAll(walkFileTreeForSearch(documentFile2, documentFileType, strArr, str, regex, thread));
                } else if (documentFileType2 != DocumentFileType.FOLDER) {
                    String name2 = documentFile2.getName();
                    if (name2 != null) {
                        str3 = name2;
                    }
                    if (str2.length() != 0) {
                        z = false;
                    }
                    if ((z || Intrinsics.areEqual((Object) str3, (Object) str2)) && (regex2 == null || regex2.matches(str3))) {
                        Intrinsics.checkNotNullExpressionValue(documentFile2, "file");
                        if (matchesMimeTypes(documentFile2, strArr)) {
                            arrayList.add(documentFile2);
                        }
                    }
                }
                i = i2;
            }
            String[] strArr3 = strArr;
            i = i2;
        }
        return arrayList;
    }

    public static /* synthetic */ boolean deleteRecursively$default(DocumentFile documentFile, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return deleteRecursively(documentFile, context, z);
    }

    public static final boolean deleteRecursively(DocumentFile documentFile, Context context, boolean z) {
        List<DocumentFile> list;
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (documentFile.isDirectory() && documentFile.canRead()) {
            if (isDownloadsDocument(documentFile)) {
                DocumentFile writableDownloadsDocumentFile = toWritableDownloadsDocumentFile(documentFile, context);
                list = writableDownloadsDocumentFile == null ? null : walkFileTreeForDeletion(writableDownloadsDocumentFile);
                if (list == null) {
                    return false;
                }
            } else {
                list = walkFileTreeForDeletion(documentFile);
            }
            int size = list.size();
            int size2 = list.size() - 1;
            if (size2 >= 0) {
                while (true) {
                    int i = size2 - 1;
                    if (list.get(size2).delete()) {
                        size--;
                    }
                    if (i < 0) {
                        break;
                    }
                    size2 = i;
                }
            }
            if (size != 0 || (!z && !documentFile.delete() && documentFile.exists())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean forceDelete$default(DocumentFile documentFile, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return forceDelete(documentFile, context, z);
    }

    public static final boolean forceDelete(DocumentFile documentFile, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (documentFile.isDirectory()) {
            return deleteRecursively(documentFile, context, z);
        }
        return documentFile.delete() || !documentFile.exists();
    }

    private static final List<DocumentFile> walkFileTreeForDeletion(DocumentFile documentFile) {
        List<DocumentFile> arrayList = new ArrayList<>();
        DocumentFile[] listFiles = documentFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
        Object[] objArr = (Object[]) listFiles;
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            DocumentFile documentFile2 = (DocumentFile) obj;
            if (!documentFile2.delete()) {
                Intrinsics.checkNotNullExpressionValue(documentFile2, "it");
                arrayList.add(documentFile2);
            }
            if (documentFile2.isDirectory()) {
                Intrinsics.checkNotNullExpressionValue(documentFile2, "it");
                arrayList.addAll(walkFileTreeForDeletion(documentFile2));
            }
        }
        return arrayList;
    }

    public static final boolean deleteEmptyFolders(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isRawFile(documentFile)) {
            String path = documentFile.getUri().getPath();
            Intrinsics.checkNotNull(path);
            FileUtils.deleteEmptyFolders(new File(path), context);
            return true;
        } else if (!documentFile.isDirectory() || !isWritable(documentFile, context)) {
            return false;
        } else {
            for (DocumentFile delete : CollectionsKt.reversed(walkFileTreeAndDeleteEmptyFolders(documentFile))) {
                delete.delete();
            }
            return true;
        }
    }

    private static final List<DocumentFile> walkFileTreeAndDeleteEmptyFolders(DocumentFile documentFile) {
        List<DocumentFile> arrayList = new ArrayList<>();
        DocumentFile[] listFiles = documentFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
        Object[] objArr = (Object[]) listFiles;
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            DocumentFile documentFile2 = (DocumentFile) obj;
            if (documentFile2.isDirectory() && !documentFile2.delete()) {
                Intrinsics.checkNotNullExpressionValue(documentFile2, "it");
                arrayList.add(documentFile2);
                arrayList.addAll(walkFileTreeAndDeleteEmptyFolders(documentFile2));
            }
        }
        return arrayList;
    }

    public static final OutputStream openOutputStream(DocumentFile documentFile, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Uri uri = documentFile.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return UriUtils.openOutputStream(uri, context, z);
    }

    public static /* synthetic */ OutputStream openOutputStream$default(DocumentFile documentFile, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return openOutputStream(documentFile, context, z);
    }

    public static final InputStream openInputStream(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Uri uri = documentFile.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return UriUtils.openInputStream(uri, context);
    }

    public static final Intent openFileIntent(DocumentFile documentFile, Context context, String str) {
        Uri uri;
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "authority");
        Intent intent = new Intent("android.intent.action.VIEW");
        if (isRawFile(documentFile)) {
            String path = documentFile.getUri().getPath();
            Intrinsics.checkNotNull(path);
            uri = FileProvider.getUriForFile(context, str, new File(path));
        } else {
            uri = documentFile.getUri();
        }
        Intent addFlags = intent.setData(uri).addFlags(1).addFlags(268435456);
        Intrinsics.checkNotNullExpressionValue(addFlags, "Intent(Intent.ACTION_VIE…t.FLAG_ACTIVITY_NEW_TASK)");
        return addFlags;
    }

    public static final boolean hasParent(DocumentFile documentFile, Context context, DocumentFile documentFile2) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(documentFile2, "parent");
        return TextUtils.hasParent(getAbsolutePath(documentFile, context), getAbsolutePath(documentFile2, context));
    }

    private static final List<DocumentFile> walkFileTree(DocumentFile documentFile, Context context) {
        List<DocumentFile> arrayList = new ArrayList<>();
        DocumentFile[] listFiles = documentFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
        Object[] objArr = (Object[]) listFiles;
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            DocumentFile documentFile2 = (DocumentFile) obj;
            if (documentFile2.isDirectory()) {
                Intrinsics.checkNotNullExpressionValue(documentFile2, "it");
                if (isEmpty(documentFile2, context)) {
                    arrayList.add(documentFile2);
                } else {
                    arrayList.addAll(walkFileTree(documentFile2, context));
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(documentFile2, "it");
                arrayList.add(documentFile2);
            }
        }
        return arrayList;
    }

    private static final List<DocumentFile> walkFileTreeAndSkipEmptyFiles(DocumentFile documentFile) {
        List<DocumentFile> arrayList = new ArrayList<>();
        DocumentFile[] listFiles = documentFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
        Object[] objArr = (Object[]) listFiles;
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            DocumentFile documentFile2 = (DocumentFile) obj;
            if (documentFile2.isDirectory()) {
                Intrinsics.checkNotNullExpressionValue(documentFile2, "it");
                arrayList.addAll(walkFileTreeAndSkipEmptyFiles(documentFile2));
            } else if (documentFile2.length() > 0) {
                Intrinsics.checkNotNullExpressionValue(documentFile2, "it");
                arrayList.add(documentFile2);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void moveTo$default(List list, Context context, DocumentFile documentFile, boolean z, MultipleFileCallback multipleFileCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        moveTo(list, context, documentFile, z, multipleFileCallback);
    }

    public static final void moveTo(List<? extends DocumentFile> list, Context context, DocumentFile documentFile, boolean z, MultipleFileCallback multipleFileCallback) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(documentFile, "targetParentFolder");
        Intrinsics.checkNotNullParameter(multipleFileCallback, "callback");
        copyTo(list, context, documentFile, z, true, multipleFileCallback);
    }

    public static /* synthetic */ void copyTo$default(List list, Context context, DocumentFile documentFile, boolean z, MultipleFileCallback multipleFileCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        copyTo(list, context, documentFile, z, multipleFileCallback);
    }

    public static final void copyTo(List<? extends DocumentFile> list, Context context, DocumentFile documentFile, boolean z, MultipleFileCallback multipleFileCallback) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(documentFile, "targetParentFolder");
        Intrinsics.checkNotNullParameter(multipleFileCallback, "callback");
        copyTo(list, context, documentFile, z, false, multipleFileCallback);
    }

    static /* synthetic */ void copyTo$default(List list, Context context, DocumentFile documentFile, boolean z, boolean z2, MultipleFileCallback multipleFileCallback, int i, Object obj) {
        copyTo(list, context, documentFile, (i & 4) != 0 ? true : z, z2, multipleFileCallback);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:152:0x04c6, code lost:
        r1 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:?, code lost:
        r1.element = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0527, code lost:
        r0 = e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x054f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0550  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x058e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x058f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void copyTo(java.util.List<? extends androidx.documentfile.provider.DocumentFile> r39, android.content.Context r40, androidx.documentfile.provider.DocumentFile r41, boolean r42, boolean r43, com.anggrayudi.storage.callback.MultipleFileCallback r44) {
        /*
            r12 = r40
            r0 = r39
            r1 = r41
            r13 = r44
            kotlin.Pair r0 = doesMeetCopyRequirements(r0, r12, r1, r13)
            if (r0 != 0) goto L_0x000f
            return
        L_0x000f:
            kotlinx.coroutines.CoroutineScope r1 = r44.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            r3 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyTo$$inlined$postToUi$1 r4 = new com.anggrayudi.storage.file.DocumentFileUtils$copyTo$$inlined$postToUi$1
            r14 = 0
            r4.<init>(r14, r13)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r5 = 2
            r6 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r1, r2, r3, r4, r5, r6)
            java.lang.Object r1 = r0.getSecond()
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r0 = r0.getFirst()
            r15 = r0
            androidx.documentfile.provider.DocumentFile r15 = (androidx.documentfile.provider.DocumentFile) r15
            java.util.List r0 = handleParentFolderConflict((java.util.List<? extends androidx.documentfile.provider.DocumentFile>) r1, (android.content.Context) r12, (androidx.documentfile.provider.DocumentFile) r15, (com.anggrayudi.storage.callback.MultipleFileCallback) r13)
            if (r0 != 0) goto L_0x003b
            return
        L_0x003b:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r3 = r0.iterator()
        L_0x0048:
            boolean r4 = r3.hasNext()
            r10 = 1
            if (r4 == 0) goto L_0x0067
            java.lang.Object r4 = r3.next()
            r5 = r4
            com.anggrayudi.storage.callback.MultipleFileCallback$ParentConflict r5 = (com.anggrayudi.storage.callback.MultipleFileCallback.ParentConflict) r5
            com.anggrayudi.storage.callback.FolderCallback$ConflictResolution r5 = r5.getSolution()
            com.anggrayudi.storage.callback.FolderCallback$ConflictResolution r6 = com.anggrayudi.storage.callback.FolderCallback.ConflictResolution.SKIP
            if (r5 != r6) goto L_0x0060
            r11 = 1
            goto L_0x0061
        L_0x0060:
            r11 = 0
        L_0x0061:
            if (r11 == 0) goto L_0x0048
            r2.add(r4)
            goto L_0x0048
        L_0x0067:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r4)
            r3.<init>(r5)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r2 = r2.iterator()
        L_0x007c:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0090
            java.lang.Object r5 = r2.next()
            com.anggrayudi.storage.callback.MultipleFileCallback$ParentConflict r5 = (com.anggrayudi.storage.callback.MultipleFileCallback.ParentConflict) r5
            androidx.documentfile.provider.DocumentFile r5 = r5.getSource()
            r3.add(r5)
            goto L_0x007c
        L_0x0090:
            java.util.List r3 = (java.util.List) r3
            java.util.Collection r3 = (java.util.Collection) r3
            r1.removeAll(r3)
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x009e
            return
        L_0x009e:
            kotlinx.coroutines.CoroutineScope r16 = r44.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getMain()
            r17 = r2
            kotlin.coroutines.CoroutineContext r17 = (kotlin.coroutines.CoroutineContext) r17
            r18 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyTo$$inlined$postToUi$2 r2 = new com.anggrayudi.storage.file.DocumentFileUtils$copyTo$$inlined$postToUi$2
            r2.<init>(r14, r13)
            r19 = r2
            kotlin.jvm.functions.Function2 r19 = (kotlin.jvm.functions.Function2) r19
            r20 = 2
            r21 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r16, r17, r18, r19, r20, r21)
            r8 = r1
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r4)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r2 = r8.iterator()
        L_0x00ce:
            boolean r3 = r2.hasNext()
            r16 = 0
            if (r3 == 0) goto L_0x014d
            java.lang.Object r3 = r2.next()
            androidx.documentfile.provider.DocumentFile r3 = (androidx.documentfile.provider.DocumentFile) r3
            if (r42 == 0) goto L_0x00e3
            java.util.List r4 = walkFileTreeAndSkipEmptyFiles(r3)
            goto L_0x00e7
        L_0x00e3:
            java.util.List r4 = walkFileTree(r3, r12)
        L_0x00e7:
            r19 = r4
            r4 = r19
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
            r20 = r16
            r22 = 0
        L_0x00f5:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0110
            java.lang.Object r5 = r4.next()
            androidx.documentfile.provider.DocumentFile r5 = (androidx.documentfile.provider.DocumentFile) r5
            boolean r6 = r5.isFile()
            if (r6 == 0) goto L_0x00f5
            int r22 = r22 + 1
            long r5 = r5.length()
            long r20 = r20 + r5
            goto L_0x00f5
        L_0x0110:
            java.util.Iterator r4 = r0.iterator()
        L_0x0114:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x012c
            java.lang.Object r5 = r4.next()
            r6 = r5
            com.anggrayudi.storage.callback.MultipleFileCallback$ParentConflict r6 = (com.anggrayudi.storage.callback.MultipleFileCallback.ParentConflict) r6
            androidx.documentfile.provider.DocumentFile r6 = r6.getSource()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r3)
            if (r6 == 0) goto L_0x0114
            goto L_0x012d
        L_0x012c:
            r5 = r14
        L_0x012d:
            com.anggrayudi.storage.callback.MultipleFileCallback$ParentConflict r5 = (com.anggrayudi.storage.callback.MultipleFileCallback.ParentConflict) r5
            if (r5 != 0) goto L_0x0133
            r4 = r14
            goto L_0x0137
        L_0x0133:
            com.anggrayudi.storage.callback.FolderCallback$ConflictResolution r4 = r5.getSolution()
        L_0x0137:
            if (r4 != 0) goto L_0x013b
            com.anggrayudi.storage.callback.FolderCallback$ConflictResolution r4 = com.anggrayudi.storage.callback.FolderCallback.ConflictResolution.CREATE_NEW
        L_0x013b:
            r23 = r4
            kotlin.Pair r4 = new kotlin.Pair
            com.anggrayudi.storage.file.DocumentFileUtils$copyTo$SourceInfo r5 = new com.anggrayudi.storage.file.DocumentFileUtils$copyTo$SourceInfo
            r18 = r5
            r18.<init>(r19, r20, r22, r23)
            r4.<init>(r3, r5)
            r1.add(r4)
            goto L_0x00ce
        L_0x014d:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Map r0 = kotlin.collections.MapsKt.toMap(r1)
            java.util.Map r9 = kotlin.collections.MapsKt.toMutableMap(r0)
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            r7 = r0
            java.util.Map r7 = (java.util.Map) r7
            if (r43 == 0) goto L_0x0259
            java.util.Set r0 = r9.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x016b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01db
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            r6 = r2
            androidx.documentfile.provider.DocumentFile r6 = (androidx.documentfile.provider.DocumentFile) r6
            java.lang.Object r1 = r1.getValue()
            com.anggrayudi.storage.file.DocumentFileUtils$copyTo$SourceInfo r1 = (com.anggrayudi.storage.file.DocumentFileUtils$copyTo$SourceInfo) r1
            java.lang.String r4 = getFullName(r6)
            r18 = 0
            com.anggrayudi.storage.callback.FolderCallback$ConflictResolution r19 = r1.getConflictResolution()
            r1 = r6
            r2 = r40
            r3 = r15
            r5 = r42
            r11 = r6
            r6 = r18
            r14 = r7
            r7 = r19
            java.lang.Object r1 = tryMoveFolderByRenamingPath(r1, r2, r3, r4, r5, r6, r7)
            boolean r2 = r1 instanceof androidx.documentfile.provider.DocumentFile
            if (r2 == 0) goto L_0x01a6
            r14.put(r11, r1)
            goto L_0x01d8
        L_0x01a6:
            boolean r2 = r1 instanceof com.anggrayudi.storage.callback.FolderCallback.ErrorCode
            if (r2 == 0) goto L_0x01d8
            com.anggrayudi.storage.callback.FolderCallback$ErrorCode r1 = (com.anggrayudi.storage.callback.FolderCallback.ErrorCode) r1
            int[] r0 = com.anggrayudi.storage.file.DocumentFileUtils.WhenMappings.$EnumSwitchMapping$1
            int r1 = r1.ordinal()
            r0 = r0[r1]
            if (r0 == r10) goto L_0x01bd
            r1 = 2
            if (r0 == r1) goto L_0x01ba
            return
        L_0x01ba:
            com.anggrayudi.storage.callback.MultipleFileCallback$ErrorCode r0 = com.anggrayudi.storage.callback.MultipleFileCallback.ErrorCode.STORAGE_PERMISSION_DENIED
            goto L_0x01bf
        L_0x01bd:
            com.anggrayudi.storage.callback.MultipleFileCallback$ErrorCode r0 = com.anggrayudi.storage.callback.MultipleFileCallback.ErrorCode.INVALID_TARGET_FOLDER
        L_0x01bf:
            kotlinx.coroutines.CoroutineScope r1 = r44.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            r3 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyTo$lambda-54$$inlined$postToUi$1 r4 = new com.anggrayudi.storage.file.DocumentFileUtils$copyTo$lambda-54$$inlined$postToUi$1
            r5 = 0
            r4.<init>(r5, r13, r0)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r5 = 2
            r6 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r1, r2, r3, r4, r5, r6)
            return
        L_0x01d8:
            r7 = r14
            r14 = 0
            goto L_0x016b
        L_0x01db:
            r14 = r7
            java.util.Set r0 = r14.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x01e5:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0208
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r2 = r2.getKey()
            java.lang.Object r2 = r9.remove(r2)
            com.anggrayudi.storage.file.DocumentFileUtils$copyTo$SourceInfo r2 = (com.anggrayudi.storage.file.DocumentFileUtils$copyTo$SourceInfo) r2
            if (r2 != 0) goto L_0x01fe
            goto L_0x01e5
        L_0x01fe:
            int r2 = r2.getTotalFiles()
            int r1 = r1 + r2
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            goto L_0x01e5
        L_0x0208:
            boolean r0 = r9.isEmpty()
            if (r0 == 0) goto L_0x025a
            java.util.ArrayList r0 = new java.util.ArrayList
            int r2 = r14.size()
            r0.<init>(r2)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Set r2 = r14.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0221:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0237
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r3 = r3.getValue()
            androidx.documentfile.provider.DocumentFile r3 = (androidx.documentfile.provider.DocumentFile) r3
            r0.add(r3)
            goto L_0x0221
        L_0x0237:
            java.util.List r0 = (java.util.List) r0
            com.anggrayudi.storage.callback.MultipleFileCallback$Result r2 = new com.anggrayudi.storage.callback.MultipleFileCallback$Result
            r2.<init>(r0, r1, r1, r10)
            kotlinx.coroutines.CoroutineScope r3 = r44.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getMain()
            r4 = r0
            kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
            r5 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyTo$$inlined$postToUi$3 r0 = new com.anggrayudi.storage.file.DocumentFileUtils$copyTo$$inlined$postToUi$3
            r1 = 0
            r0.<init>(r1, r13, r2)
            r6 = r0
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r7 = 2
            r8 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r3, r4, r5, r6, r7, r8)
            return
        L_0x0259:
            r14 = r7
        L_0x025a:
            java.util.Collection r0 = r9.values()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r6 = r16
        L_0x0266:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0278
            java.lang.Object r1 = r0.next()
            com.anggrayudi.storage.file.DocumentFileUtils$copyTo$SourceInfo r1 = (com.anggrayudi.storage.file.DocumentFileUtils$copyTo$SourceInfo) r1
            long r1 = r1.getSize()
            long r6 = r6 + r1
            goto L_0x0266
        L_0x0278:
            java.lang.String r0 = getStorageId(r15, r12)     // Catch:{ all -> 0x06a8 }
            long r0 = com.anggrayudi.storage.file.DocumentFileCompat.getFreeSpace(r12, r0)     // Catch:{ all -> 0x06a8 }
            boolean r0 = r13.onCheckFreeSpace(r0, r6)     // Catch:{ all -> 0x06a8 }
            if (r0 != 0) goto L_0x02a6
            kotlinx.coroutines.CoroutineScope r18 = r44.getUiScope()     // Catch:{ all -> 0x06a8 }
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getMain()     // Catch:{ all -> 0x06a8 }
            r19 = r0
            kotlin.coroutines.CoroutineContext r19 = (kotlin.coroutines.CoroutineContext) r19     // Catch:{ all -> 0x06a8 }
            r20 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyTo$$inlined$postToUi$4 r0 = new com.anggrayudi.storage.file.DocumentFileUtils$copyTo$$inlined$postToUi$4     // Catch:{ all -> 0x06a8 }
            r1 = 0
            r0.<init>(r1, r13)     // Catch:{ all -> 0x06a8 }
            r21 = r0
            kotlin.jvm.functions.Function2 r21 = (kotlin.jvm.functions.Function2) r21     // Catch:{ all -> 0x06a8 }
            r22 = 2
            r23 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x06a8 }
            return
        L_0x02a6:
            java.lang.Thread r18 = java.lang.Thread.currentThread()
            boolean r0 = r8 instanceof java.util.Collection
            if (r0 == 0) goto L_0x02b9
            r0 = r8
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x02b9
            r1 = 0
            goto L_0x02d8
        L_0x02b9:
            java.util.Iterator r0 = r8.iterator()
            r1 = 0
        L_0x02be:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x02d8
            java.lang.Object r2 = r0.next()
            androidx.documentfile.provider.DocumentFile r2 = (androidx.documentfile.provider.DocumentFile) r2
            boolean r2 = r2.isFile()
            if (r2 == 0) goto L_0x02be
            int r1 = r1 + 1
            if (r1 >= 0) goto L_0x02be
            kotlin.collections.CollectionsKt.throwCountOverflow()
            goto L_0x02be
        L_0x02d8:
            java.util.Collection r0 = r9.values()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
        L_0x02e3:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x02f5
            java.lang.Object r3 = r0.next()
            com.anggrayudi.storage.file.DocumentFileUtils$copyTo$SourceInfo r3 = (com.anggrayudi.storage.file.DocumentFileUtils$copyTo$SourceInfo) r3
            int r3 = r3.getTotalFiles()
            int r2 = r2 + r3
            goto L_0x02e3
        L_0x02f5:
            int r11 = r1 + r2
            kotlinx.coroutines.CoroutineScope r1 = r44.getUiScope()
            com.anggrayudi.storage.file.DocumentFileUtils$copyTo$$inlined$awaitUiResult$1 r8 = new com.anggrayudi.storage.file.DocumentFileUtils$copyTo$$inlined$awaitUiResult$1
            r2 = 0
            r0 = r8
            r3 = r44
            r4 = r9
            r5 = r11
            r19 = r6
            r6 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r1 = 0
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(r1, r8, r10, r1)
            java.lang.Number r0 = (java.lang.Number) r0
            long r1 = r0.longValue()
            int r0 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r0 >= 0) goto L_0x031c
            return
        L_0x031c:
            kotlin.jvm.internal.Ref$IntRef r8 = new kotlin.jvm.internal.Ref$IntRef
            r8.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            kotlin.jvm.internal.Ref$LongRef r5 = new kotlin.jvm.internal.Ref$LongRef
            r5.<init>()
            kotlin.jvm.internal.Ref$IntRef r21 = new kotlin.jvm.internal.Ref$IntRef
            r21.<init>()
            com.anggrayudi.storage.file.DocumentFileUtils$copyTo$startTimer$1 r22 = new com.anggrayudi.storage.file.DocumentFileUtils$copyTo$startTimer$1
            r0 = r22
            r3 = r7
            r4 = r5
            r42 = r5
            r5 = r19
            r23 = r7
            r7 = r21
            r24 = r8
            r25 = r9
            r9 = r44
            r0.<init>(r1, r3, r4, r5, r7, r8, r9)
            r9 = r22
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r26 = 10485760(0xa00000, double:5.180654E-317)
            int r0 = (r19 > r26 ? 1 : (r19 == r26 ? 0 : -1))
            if (r0 <= 0) goto L_0x0354
            r0 = 1
            goto L_0x0355
        L_0x0354:
            r0 = 0
        L_0x0355:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r9.invoke(r0)
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            kotlin.jvm.internal.Ref$BooleanRef r1 = new kotlin.jvm.internal.Ref$BooleanRef
            r1.<init>()
            com.anggrayudi.storage.file.DocumentFileUtils$copyTo$notifyCanceled$1 r22 = new com.anggrayudi.storage.file.DocumentFileUtils$copyTo$notifyCanceled$1
            r0 = r22
            r2 = r23
            r3 = r8
            r4 = r14
            r5 = r11
            r6 = r24
            r7 = r44
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r7 = r22
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r0]
            kotlin.jvm.internal.Ref$BooleanRef r5 = new kotlin.jvm.internal.Ref$BooleanRef
            r5.<init>()
            r5.element = r10
            com.anggrayudi.storage.file.DocumentFileUtils$copyTo$copy$1 r0 = new com.anggrayudi.storage.file.DocumentFileUtils$copyTo$copy$1
            r1 = r0
            r2 = r40
            r3 = r44
            r4 = r24
            r28 = r5
            r5 = r43
            r10 = r7
            r7 = r42
            r29 = r9
            r9 = r8
            r8 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r8 = r0
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            com.anggrayudi.storage.file.DocumentFileUtils$copyTo$handleError$1 r0 = new com.anggrayudi.storage.file.DocumentFileUtils$copyTo$handleError$1
            r2 = r23
            r0.<init>(r10, r2, r13)
            r7 = r0
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r6 = r0
            java.util.List r6 = (java.util.List) r6
            java.util.Set r0 = r25.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x03ba:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0554
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r3 = r1.getKey()
            androidx.documentfile.provider.DocumentFile r3 = (androidx.documentfile.provider.DocumentFile) r3
            java.lang.Object r1 = r1.getValue()
            com.anggrayudi.storage.file.DocumentFileUtils$copyTo$SourceInfo r1 = (com.anggrayudi.storage.file.DocumentFileUtils$copyTo$SourceInfo) r1
            boolean r4 = r18.isInterrupted()
            if (r4 == 0) goto L_0x03de
            com.anggrayudi.storage.callback.MultipleFileCallback$ErrorCode r0 = com.anggrayudi.storage.callback.MultipleFileCallback.ErrorCode.CANCELED
            r10.invoke(r0)
            return
        L_0x03de:
            com.anggrayudi.storage.callback.FolderCallback$ConflictResolution r4 = r1.getConflictResolution()
            com.anggrayudi.storage.file.CreateMode r4 = r4.toCreateMode()
            boolean r5 = r3.isDirectory()
            if (r5 == 0) goto L_0x03f7
            java.lang.String r5 = getFullName(r3)
            androidx.documentfile.provider.DocumentFile r4 = makeFolder(r15, r12, r5, r4)
            r21 = r0
            goto L_0x0405
        L_0x03f7:
            java.lang.String r5 = getFullName(r3)
            r21 = r0
            java.lang.String r0 = getMimeType(r3)
            androidx.documentfile.provider.DocumentFile r4 = makeFile(r15, r12, r5, r0, r4)
        L_0x0405:
            if (r4 != 0) goto L_0x043a
            T r0 = r2.element
            kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0
            r1 = 0
            if (r0 != 0) goto L_0x040f
            goto L_0x0415
        L_0x040f:
            r5 = 1
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r0, (java.util.concurrent.CancellationException) r1, (int) r5, (java.lang.Object) r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0415:
            kotlinx.coroutines.CoroutineScope r0 = r44.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            r3 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyTo$$inlined$postToUi$6 r4 = new com.anggrayudi.storage.file.DocumentFileUtils$copyTo$$inlined$postToUi$6
            r4.<init>(r1, r13)
            r1 = r4
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r4 = 2
            r5 = 0
            r39 = r0
            r40 = r2
            r41 = r3
            r42 = r1
            r43 = r4
            r44 = r5
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r39, r40, r41, r42, r43, r44)
            return
        L_0x043a:
            r5 = 1
            boolean r0 = r4.isFile()     // Catch:{ Exception -> 0x053e }
            if (r0 == 0) goto L_0x044b
            r8.invoke(r3, r4)     // Catch:{ Exception -> 0x053e }
            r14.put(r3, r4)     // Catch:{ Exception -> 0x053e }
            r0 = r21
            goto L_0x03ba
        L_0x044b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x053e }
            r0.<init>()     // Catch:{ Exception -> 0x053e }
            java.lang.String r5 = getAbsolutePath(r15, r12)     // Catch:{ Exception -> 0x053e }
            r0.append(r5)     // Catch:{ Exception -> 0x053e }
            r5 = 47
            r0.append(r5)     // Catch:{ Exception -> 0x053e }
            java.lang.String r5 = getFullName(r3)     // Catch:{ Exception -> 0x053e }
            r0.append(r5)     // Catch:{ Exception -> 0x053e }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x053e }
            java.util.List r1 = r1.getChildren()     // Catch:{ Exception -> 0x053e }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x053e }
        L_0x046f:
            boolean r5 = r1.hasNext()     // Catch:{ Exception -> 0x053e }
            if (r5 == 0) goto L_0x0529
            java.lang.Object r5 = r1.next()     // Catch:{ Exception -> 0x053e }
            androidx.documentfile.provider.DocumentFile r5 = (androidx.documentfile.provider.DocumentFile) r5     // Catch:{ Exception -> 0x053e }
            boolean r30 = r18.isInterrupted()     // Catch:{ Exception -> 0x053e }
            if (r30 == 0) goto L_0x0487
            com.anggrayudi.storage.callback.MultipleFileCallback$ErrorCode r0 = com.anggrayudi.storage.callback.MultipleFileCallback.ErrorCode.CANCELED     // Catch:{ Exception -> 0x053e }
            r10.invoke(r0)     // Catch:{ Exception -> 0x053e }
            return
        L_0x0487:
            boolean r30 = r5.exists()     // Catch:{ Exception -> 0x053e }
            if (r30 != 0) goto L_0x048e
            goto L_0x046f
        L_0x048e:
            r36 = r1
            java.lang.String r1 = getSubPath(r5, r12, r0)     // Catch:{ Exception -> 0x053e }
            r37 = r0
            java.lang.String r0 = ""
            r13 = 47
            java.lang.String r0 = kotlin.text.StringsKt.substringBeforeLast((java.lang.String) r1, (char) r13, (java.lang.String) r0)     // Catch:{ Exception -> 0x053e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x053e }
            r1.<init>()     // Catch:{ Exception -> 0x053e }
            r1.append(r0)     // Catch:{ Exception -> 0x053e }
            r1.append(r13)     // Catch:{ Exception -> 0x053e }
            java.lang.String r0 = getFullName(r5)     // Catch:{ Exception -> 0x053e }
            r1.append(r0)     // Catch:{ Exception -> 0x053e }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x053e }
            java.lang.String r0 = com.anggrayudi.storage.extension.TextUtils.trimFileSeparator(r0)     // Catch:{ Exception -> 0x053e }
            boolean r1 = r5.isDirectory()     // Catch:{ Exception -> 0x053e }
            if (r1 == 0) goto L_0x04d3
            com.anggrayudi.storage.file.CreateMode r1 = com.anggrayudi.storage.file.CreateMode.REUSE     // Catch:{ Exception -> 0x053e }
            androidx.documentfile.provider.DocumentFile r0 = makeFolder(r4, r12, r0, r1)     // Catch:{ Exception -> 0x053e }
            if (r0 != 0) goto L_0x04cc
            r1 = r28
            r5 = 0
            r1.element = r5     // Catch:{ Exception -> 0x0527 }
            goto L_0x052b
        L_0x04cc:
            r13 = r44
            r1 = r36
            r0 = r37
            goto L_0x046f
        L_0x04d3:
            r1 = r28
            java.lang.String r13 = r5.getType()     // Catch:{ Exception -> 0x0527 }
            r28 = r15
            com.anggrayudi.storage.file.CreateMode r15 = com.anggrayudi.storage.file.CreateMode.REUSE     // Catch:{ Exception -> 0x053c }
            androidx.documentfile.provider.DocumentFile r0 = makeFile(r4, r12, r0, r13, r15)     // Catch:{ Exception -> 0x053c }
            r9.element = r0     // Catch:{ Exception -> 0x053c }
            T r0 = r9.element     // Catch:{ Exception -> 0x053c }
            if (r0 == 0) goto L_0x050c
            T r0 = r9.element     // Catch:{ Exception -> 0x053c }
            androidx.documentfile.provider.DocumentFile r0 = (androidx.documentfile.provider.DocumentFile) r0     // Catch:{ Exception -> 0x053c }
            long r30 = r0.length()     // Catch:{ Exception -> 0x053c }
            int r0 = (r30 > r16 ? 1 : (r30 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x050c
            com.anggrayudi.storage.callback.FolderCallback$FileConflict r0 = new com.anggrayudi.storage.callback.FolderCallback$FileConflict     // Catch:{ Exception -> 0x053c }
            T r13 = r9.element     // Catch:{ Exception -> 0x053c }
            r32 = r13
            androidx.documentfile.provider.DocumentFile r32 = (androidx.documentfile.provider.DocumentFile) r32     // Catch:{ Exception -> 0x053c }
            r33 = 0
            r34 = 4
            r35 = 0
            r30 = r0
            r31 = r5
            r30.<init>(r31, r32, r33, r34, r35)     // Catch:{ Exception -> 0x053c }
            r6.add(r0)     // Catch:{ Exception -> 0x053c }
            goto L_0x051b
        L_0x050c:
            T r0 = r9.element     // Catch:{ Exception -> 0x053c }
            if (r0 != 0) goto L_0x0516
            com.anggrayudi.storage.callback.MultipleFileCallback$ErrorCode r0 = com.anggrayudi.storage.callback.MultipleFileCallback.ErrorCode.CANNOT_CREATE_FILE_IN_TARGET     // Catch:{ Exception -> 0x053c }
            r10.invoke(r0)     // Catch:{ Exception -> 0x053c }
            return
        L_0x0516:
            T r0 = r9.element     // Catch:{ Exception -> 0x053c }
            r8.invoke(r5, r0)     // Catch:{ Exception -> 0x053c }
        L_0x051b:
            r13 = r44
            r15 = r28
            r0 = r37
            r28 = r1
            r1 = r36
            goto L_0x046f
        L_0x0527:
            r0 = move-exception
            goto L_0x0541
        L_0x0529:
            r1 = r28
        L_0x052b:
            r28 = r15
            r14.put(r3, r4)     // Catch:{ Exception -> 0x053c }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r13 = r44
            r0 = r21
            r15 = r28
            r28 = r1
            goto L_0x03ba
        L_0x053c:
            r0 = move-exception
            goto L_0x0543
        L_0x053e:
            r0 = move-exception
            r1 = r28
        L_0x0541:
            r28 = r15
        L_0x0543:
            java.lang.Object r0 = r7.invoke(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0550
            return
        L_0x0550:
            r13 = 0
            r1.element = r13
            goto L_0x0559
        L_0x0554:
            r1 = r28
            r13 = 0
            r28 = r15
        L_0x0559:
            com.anggrayudi.storage.file.DocumentFileUtils$copyTo$finalize$1 r0 = new com.anggrayudi.storage.file.DocumentFileUtils$copyTo$finalize$1
            r15 = r1
            r1 = r0
            r3 = r15
            r4 = r6
            r16 = 1
            r5 = r43
            r17 = r6
            r6 = r25
            r13 = r7
            r7 = r14
            r14 = r8
            r8 = r11
            r12 = r9
            r11 = r29
            r9 = r24
            r16 = r13
            r21 = r15
            r13 = 1
            r15 = r10
            r10 = r44
            r38 = r11
            r11 = r40
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r8 = r0
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            java.lang.Object r0 = r8.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x058f
            return
        L_0x058f:
            kotlinx.coroutines.CoroutineScope r1 = r44.getUiScope()
            com.anggrayudi.storage.file.DocumentFileUtils$copyTo$$inlined$awaitUiResultWithPending$1 r6 = new com.anggrayudi.storage.file.DocumentFileUtils$copyTo$$inlined$awaitUiResultWithPending$1
            r2 = 0
            r0 = r6
            r3 = r44
            r4 = r28
            r5 = r17
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r1 = 0
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(r1, r6, r13, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x05b4:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x05ef
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.anggrayudi.storage.callback.FolderCallback$FileConflict r3 = (com.anggrayudi.storage.callback.FolderCallback.FileConflict) r3
            com.anggrayudi.storage.callback.FileCallback$ConflictResolution r4 = r3.getSolution()
            com.anggrayudi.storage.callback.FileCallback$ConflictResolution r5 = com.anggrayudi.storage.callback.FileCallback.ConflictResolution.SKIP
            if (r4 != r5) goto L_0x05da
            if (r43 == 0) goto L_0x05d2
            androidx.documentfile.provider.DocumentFile r4 = r3.getSource()
            r4.delete()
        L_0x05d2:
            r4 = r24
            int r5 = r4.element
            int r5 = r5 + r13
            r4.element = r5
            goto L_0x05dc
        L_0x05da:
            r4 = r24
        L_0x05dc:
            com.anggrayudi.storage.callback.FileCallback$ConflictResolution r3 = r3.getSolution()
            com.anggrayudi.storage.callback.FileCallback$ConflictResolution r5 = com.anggrayudi.storage.callback.FileCallback.ConflictResolution.SKIP
            if (r3 == r5) goto L_0x05e6
            r11 = 1
            goto L_0x05e7
        L_0x05e6:
            r11 = 0
        L_0x05e7:
            if (r11 == 0) goto L_0x05ec
            r1.add(r2)
        L_0x05ec:
            r24 = r4
            goto L_0x05b4
        L_0x05ef:
            java.util.List r1 = (java.util.List) r1
            r2 = r42
            long r2 = r2.element
            long r6 = r19 - r2
            r0 = r1
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r13
            if (r0 == 0) goto L_0x0607
            int r0 = (r6 > r26 ? 1 : (r6 == r26 ? 0 : -1))
            if (r0 <= 0) goto L_0x0607
            r11 = 1
            goto L_0x0608
        L_0x0607:
            r11 = 0
        L_0x0608:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r11)
            r2 = r38
            r2.invoke(r0)
            java.util.Iterator r0 = r1.iterator()
        L_0x0615:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x06a4
            java.lang.Object r1 = r0.next()
            r9 = r1
            com.anggrayudi.storage.callback.FolderCallback$FileConflict r9 = (com.anggrayudi.storage.callback.FolderCallback.FileConflict) r9
            boolean r1 = r18.isInterrupted()
            if (r1 == 0) goto L_0x062e
            com.anggrayudi.storage.callback.MultipleFileCallback$ErrorCode r0 = com.anggrayudi.storage.callback.MultipleFileCallback.ErrorCode.CANCELED
            r15.invoke(r0)
            return
        L_0x062e:
            androidx.documentfile.provider.DocumentFile r1 = r9.getSource()
            boolean r1 = r1.isFile()
            if (r1 != 0) goto L_0x0639
            goto L_0x0615
        L_0x0639:
            androidx.documentfile.provider.DocumentFile r1 = r9.getTarget()
            java.lang.String r3 = getFullName(r1)
            com.anggrayudi.storage.callback.FileCallback$ConflictResolution r1 = r9.getSolution()
            com.anggrayudi.storage.callback.FileCallback$ConflictResolution r2 = com.anggrayudi.storage.callback.FileCallback.ConflictResolution.REPLACE
            if (r1 != r2) goto L_0x0660
            androidx.documentfile.provider.DocumentFile r1 = r9.getTarget()
            boolean r2 = r1.delete()
            if (r2 == 0) goto L_0x065c
            boolean r1 = r1.exists()
            if (r1 == 0) goto L_0x065a
            goto L_0x065c
        L_0x065a:
            r11 = 0
            goto L_0x065d
        L_0x065c:
            r11 = 1
        L_0x065d:
            if (r11 == 0) goto L_0x0660
            goto L_0x0615
        L_0x0660:
            androidx.documentfile.provider.DocumentFile r1 = r9.getTarget()
            androidx.documentfile.provider.DocumentFile r1 = r1.getParentFile()
            if (r1 != 0) goto L_0x066c
            r5 = 0
            goto L_0x0677
        L_0x066c:
            r4 = 0
            r5 = 0
            r6 = 12
            r7 = 0
            r2 = r40
            androidx.documentfile.provider.DocumentFile r5 = makeFile$default(r1, r2, r3, r4, r5, r6, r7)
        L_0x0677:
            r12.element = r5
            T r1 = r12.element
            if (r1 != 0) goto L_0x0683
            com.anggrayudi.storage.callback.MultipleFileCallback$ErrorCode r0 = com.anggrayudi.storage.callback.MultipleFileCallback.ErrorCode.CANNOT_CREATE_FILE_IN_TARGET
            r15.invoke(r0)
            return
        L_0x0683:
            androidx.documentfile.provider.DocumentFile r1 = r9.getSource()     // Catch:{ Exception -> 0x068f }
            T r2 = r12.element     // Catch:{ Exception -> 0x068f }
            r14.invoke(r1, r2)     // Catch:{ Exception -> 0x068f }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x0615
        L_0x068f:
            r0 = move-exception
            r1 = r16
            java.lang.Object r0 = r1.invoke(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x069f
            return
        L_0x069f:
            r1 = r21
            r2 = 0
            r1.element = r2
        L_0x06a4:
            r8.invoke()
            return
        L_0x06a8:
            kotlinx.coroutines.CoroutineScope r0 = r44.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            r2 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyTo$$inlined$postToUi$5 r3 = new com.anggrayudi.storage.file.DocumentFileUtils$copyTo$$inlined$postToUi$5
            r4 = r44
            r5 = 0
            r3.<init>(r5, r4)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = 2
            r5 = 0
            r39 = r0
            r40 = r1
            r41 = r2
            r42 = r3
            r43 = r4
            r44 = r5
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r39, r40, r41, r42, r43, r44)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileUtils.copyTo(java.util.List, android.content.Context, androidx.documentfile.provider.DocumentFile, boolean, boolean, com.anggrayudi.storage.callback.MultipleFileCallback):void");
    }

    private static final Pair<DocumentFile, List<DocumentFile>> doesMeetCopyRequirements(List<? extends DocumentFile> list, Context context, DocumentFile documentFile, MultipleFileCallback multipleFileCallback) {
        Pair pair;
        Context context2 = context;
        DocumentFile documentFile2 = documentFile;
        MultipleFileCallback multipleFileCallback2 = multipleFileCallback;
        Job unused = BuildersKt__Builders_commonKt.launch$default(multipleFileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$1((Continuation) null, multipleFileCallback2), 2, (Object) null);
        if (!documentFile.isDirectory()) {
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(multipleFileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$2((Continuation) null, multipleFileCallback2), 2, (Object) null);
            return null;
        } else if (!isWritable(documentFile2, context2)) {
            Job unused3 = BuildersKt__Builders_commonKt.launch$default(multipleFileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$3((Continuation) null, multipleFileCallback2), 2, (Object) null);
            return null;
        } else {
            String absolutePath = getAbsolutePath(documentFile2, context2);
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (Object next : list) {
                if (hashSet.add(((DocumentFile) next).getName())) {
                    arrayList.add(next);
                }
            }
            List<DocumentFile> list2 = arrayList;
            Collection arrayList2 = new ArrayList();
            for (DocumentFile documentFile3 : list2) {
                if (!documentFile3.exists()) {
                    pair = new Pair(documentFile3, FolderCallback.ErrorCode.SOURCE_FILE_NOT_FOUND);
                } else if (!documentFile3.canRead()) {
                    pair = new Pair(documentFile3, FolderCallback.ErrorCode.STORAGE_PERMISSION_DENIED);
                } else {
                    DocumentFile parentFile = documentFile3.getParentFile();
                    pair = Intrinsics.areEqual((Object) absolutePath, (Object) parentFile == null ? null : getAbsolutePath(parentFile, context2)) ? new Pair(documentFile3, FolderCallback.ErrorCode.TARGET_FOLDER_CANNOT_HAVE_SAME_PATH_WITH_SOURCE_FOLDER) : null;
                }
                if (pair != null) {
                    arrayList2.add(pair);
                }
            }
            Map map = MapsKt.toMap((List) arrayList2);
            if (!map.isEmpty()) {
                if (((Boolean) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$awaitUiResultWithPending$1(multipleFileCallback.getUiScope(), (Continuation) null, multipleFileCallback2, map), 1, (Object) null)).booleanValue()) {
                    Job unused4 = BuildersKt__Builders_commonKt.launch$default(multipleFileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$4((Continuation) null, multipleFileCallback2), 2, (Object) null);
                    return null;
                } else if (map.size() == list.size()) {
                    Job unused5 = BuildersKt__Builders_commonKt.launch$default(multipleFileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$5((Continuation) null, multipleFileCallback2), 2, (Object) null);
                    return null;
                }
            }
            DocumentFile writableDownloadsDocumentFile = isDownloadsDocument(documentFile) ? toWritableDownloadsDocumentFile(documentFile2, context2) : documentFile2;
            if (writableDownloadsDocumentFile == null) {
                Job unused6 = BuildersKt__Builders_commonKt.launch$default(multipleFileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$6((Continuation) null, multipleFileCallback2), 2, (Object) null);
                return null;
            }
            List mutableList = CollectionsKt.toMutableList(list2);
            Collection arrayList3 = new ArrayList(map.size());
            for (Map.Entry key : map.entrySet()) {
                arrayList3.add((DocumentFile) key.getKey());
            }
            mutableList.removeAll((List) arrayList3);
            return new Pair<>(writableDownloadsDocumentFile, mutableList);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x008e A[Catch:{ all -> 0x00a8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.Object tryMoveFolderByRenamingPath(androidx.documentfile.provider.DocumentFile r4, android.content.Context r5, androidx.documentfile.provider.DocumentFile r6, java.lang.String r7, boolean r8, java.lang.String r9, com.anggrayudi.storage.callback.FolderCallback.ConflictResolution r10) {
        /*
            boolean r0 = inSameMountPointWith(r4, r5, r6)
            r1 = 0
            if (r0 == 0) goto L_0x00ab
            boolean r0 = inInternalStorage(r4, r5)
            if (r0 == 0) goto L_0x002d
            java.io.File r0 = toRawFile(r4, r5)
            if (r0 != 0) goto L_0x0014
            goto L_0x002d
        L_0x0014:
            java.lang.String r2 = getAbsolutePath(r6, r5)
            com.anggrayudi.storage.callback.FileCallback$ConflictResolution r3 = r10.toFileConflictResolution()
            java.io.File r0 = com.anggrayudi.storage.file.FileUtils.moveTo((java.io.File) r0, (android.content.Context) r5, (java.lang.String) r2, (java.lang.String) r7, (com.anggrayudi.storage.callback.FileCallback.ConflictResolution) r3)
            if (r0 != 0) goto L_0x0023
            goto L_0x002d
        L_0x0023:
            if (r8 == 0) goto L_0x0028
            com.anggrayudi.storage.file.FileUtils.deleteEmptyFolders(r0, r5)
        L_0x0028:
            androidx.documentfile.provider.DocumentFile r4 = androidx.documentfile.provider.DocumentFile.fromFile(r0)
            return r4
        L_0x002d:
            boolean r0 = isExternalStorageManager(r4, r5)
            if (r0 == 0) goto L_0x005b
            java.io.File r0 = toRawFile(r4, r5)
            if (r0 != 0) goto L_0x003c
            com.anggrayudi.storage.callback.FolderCallback$ErrorCode r4 = com.anggrayudi.storage.callback.FolderCallback.ErrorCode.STORAGE_PERMISSION_DENIED
            return r4
        L_0x003c:
            java.io.File r2 = toRawFile(r6, r5)
            if (r2 != 0) goto L_0x0043
            goto L_0x005b
        L_0x0043:
            com.anggrayudi.storage.callback.FileCallback$ConflictResolution r10 = r10.toFileConflictResolution()
            java.io.File r10 = com.anggrayudi.storage.file.FileUtils.moveTo((java.io.File) r0, (android.content.Context) r5, (java.io.File) r2, (java.lang.String) r7, (com.anggrayudi.storage.callback.FileCallback.ConflictResolution) r10)
            if (r10 != 0) goto L_0x0051
            r10 = r1
            java.lang.Void r10 = (java.lang.Void) r10
            goto L_0x005b
        L_0x0051:
            if (r8 == 0) goto L_0x0056
            com.anggrayudi.storage.file.FileUtils.deleteEmptyFolders(r10, r5)
        L_0x0056:
            androidx.documentfile.provider.DocumentFile r4 = androidx.documentfile.provider.DocumentFile.fromFile(r10)
            return r4
        L_0x005b:
            int r10 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00a8 }
            r0 = 24
            if (r10 < r0) goto L_0x00ab
            boolean r10 = isRawFile(r4)     // Catch:{ all -> 0x00a8 }
            if (r10 != 0) goto L_0x00ab
            boolean r10 = isTreeDocumentFile(r6)     // Catch:{ all -> 0x00a8 }
            if (r10 == 0) goto L_0x00ab
            androidx.documentfile.provider.DocumentFile r10 = r4.getParentFile()     // Catch:{ all -> 0x00a8 }
            if (r10 != 0) goto L_0x0075
        L_0x0073:
            r4 = r1
            goto L_0x008c
        L_0x0075:
            android.net.Uri r10 = r10.getUri()     // Catch:{ all -> 0x00a8 }
            if (r10 != 0) goto L_0x007c
            goto L_0x0073
        L_0x007c:
            android.content.ContentResolver r0 = r5.getContentResolver()     // Catch:{ all -> 0x00a8 }
            android.net.Uri r4 = r4.getUri()     // Catch:{ all -> 0x00a8 }
            android.net.Uri r6 = r6.getUri()     // Catch:{ all -> 0x00a8 }
            android.net.Uri r4 = android.provider.DocumentsContract.moveDocument(r0, r4, r10, r6)     // Catch:{ all -> 0x00a8 }
        L_0x008c:
            if (r4 == 0) goto L_0x00ab
            androidx.documentfile.provider.DocumentFile r4 = com.anggrayudi.storage.extension.ContextUtils.fromTreeUri(r5, r4)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x00a5
            boolean r6 = r4.isDirectory()     // Catch:{ all -> 0x00a8 }
            if (r6 == 0) goto L_0x00a5
            if (r9 == 0) goto L_0x009f
            r4.renameTo(r7)     // Catch:{ all -> 0x00a8 }
        L_0x009f:
            if (r8 == 0) goto L_0x00a7
            deleteEmptyFolders(r4, r5)     // Catch:{ all -> 0x00a8 }
            goto L_0x00a7
        L_0x00a5:
            com.anggrayudi.storage.callback.FolderCallback$ErrorCode r4 = com.anggrayudi.storage.callback.FolderCallback.ErrorCode.INVALID_TARGET_FOLDER     // Catch:{ all -> 0x00a8 }
        L_0x00a7:
            return r4
        L_0x00a8:
            com.anggrayudi.storage.callback.FolderCallback$ErrorCode r4 = com.anggrayudi.storage.callback.FolderCallback.ErrorCode.STORAGE_PERMISSION_DENIED
            return r4
        L_0x00ab:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileUtils.tryMoveFolderByRenamingPath(androidx.documentfile.provider.DocumentFile, android.content.Context, androidx.documentfile.provider.DocumentFile, java.lang.String, boolean, java.lang.String, com.anggrayudi.storage.callback.FolderCallback$ConflictResolution):java.lang.Object");
    }

    public static /* synthetic */ void moveFolderTo$default(DocumentFile documentFile, Context context, DocumentFile documentFile2, boolean z, String str, FolderCallback folderCallback, int i, Object obj) {
        boolean z2 = (i & 4) != 0 ? true : z;
        if ((i & 8) != 0) {
            str = null;
        }
        moveFolderTo(documentFile, context, documentFile2, z2, str, folderCallback);
    }

    public static final void moveFolderTo(DocumentFile documentFile, Context context, DocumentFile documentFile2, boolean z, String str, FolderCallback folderCallback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(documentFile2, "targetParentFolder");
        Intrinsics.checkNotNullParameter(folderCallback, "callback");
        copyFolderTo(documentFile, context, documentFile2, z, str, true, folderCallback);
    }

    public static /* synthetic */ void copyFolderTo$default(DocumentFile documentFile, Context context, DocumentFile documentFile2, boolean z, String str, FolderCallback folderCallback, int i, Object obj) {
        boolean z2 = (i & 4) != 0 ? true : z;
        if ((i & 8) != 0) {
            str = null;
        }
        copyFolderTo(documentFile, context, documentFile2, z2, str, folderCallback);
    }

    public static final void copyFolderTo(DocumentFile documentFile, Context context, DocumentFile documentFile2, boolean z, String str, FolderCallback folderCallback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(documentFile2, "targetParentFolder");
        Intrinsics.checkNotNullParameter(folderCallback, "callback");
        copyFolderTo(documentFile, context, documentFile2, z, str, false, folderCallback);
    }

    static /* synthetic */ void copyFolderTo$default(DocumentFile documentFile, Context context, DocumentFile documentFile2, boolean z, String str, boolean z2, FolderCallback folderCallback, int i, Object obj) {
        boolean z3 = (i & 4) != 0 ? true : z;
        if ((i & 8) != 0) {
            str = null;
        }
        copyFolderTo(documentFile, context, documentFile2, z3, str, z2, folderCallback);
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x03d4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x03d5  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0416 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0417  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void copyFolderTo(androidx.documentfile.provider.DocumentFile r35, android.content.Context r36, androidx.documentfile.provider.DocumentFile r37, boolean r38, java.lang.String r39, boolean r40, com.anggrayudi.storage.callback.FolderCallback r41) {
        /*
            r12 = r36
            r0 = r37
            r6 = r39
            r9 = r35
            r13 = r41
            androidx.documentfile.provider.DocumentFile r10 = doesMeetCopyRequirements((androidx.documentfile.provider.DocumentFile) r9, (android.content.Context) r12, (androidx.documentfile.provider.DocumentFile) r0, (java.lang.String) r6, (com.anggrayudi.storage.callback.FolderCallback) r13)
            if (r10 != 0) goto L_0x0011
            return
        L_0x0011:
            kotlinx.coroutines.CoroutineScope r14 = r41.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            r15 = r1
            kotlin.coroutines.CoroutineContext r15 = (kotlin.coroutines.CoroutineContext) r15
            r16 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$postToUi$1 r1 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$postToUi$1
            r11 = 0
            r1.<init>(r11, r13)
            r17 = r1
            kotlin.jvm.functions.Function2 r17 = (kotlin.jvm.functions.Function2) r17
            r18 = 2
            r19 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r14, r15, r16, r17, r18, r19)
            com.anggrayudi.storage.file.DocumentFileCompat r1 = com.anggrayudi.storage.file.DocumentFileCompat.INSTANCE
            java.lang.String r14 = ""
            if (r6 != 0) goto L_0x003d
            java.lang.String r2 = r35.getName()
            if (r2 != 0) goto L_0x003e
            r2 = r14
            goto L_0x003e
        L_0x003d:
            r2 = r6
        L_0x003e:
            java.lang.String r1 = r1.removeForbiddenCharsFromFilename$storage_release(r2)
            java.lang.String r15 = com.anggrayudi.storage.extension.TextUtils.trimFileSeparator(r1)
            com.anggrayudi.storage.callback.FolderCallback$ConflictResolution r8 = handleParentFolderConflict((android.content.Context) r12, (androidx.documentfile.provider.DocumentFile) r0, (java.lang.String) r15, (com.anggrayudi.storage.callback.FolderCallback) r13)
            com.anggrayudi.storage.callback.FolderCallback$ConflictResolution r0 = com.anggrayudi.storage.callback.FolderCallback.ConflictResolution.SKIP
            if (r8 != r0) goto L_0x004f
            return
        L_0x004f:
            kotlinx.coroutines.CoroutineScope r16 = r41.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getMain()
            r17 = r0
            kotlin.coroutines.CoroutineContext r17 = (kotlin.coroutines.CoroutineContext) r17
            r18 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$postToUi$2 r0 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$postToUi$2
            r0.<init>(r11, r13)
            r19 = r0
            kotlin.jvm.functions.Function2 r19 = (kotlin.jvm.functions.Function2) r19
            r20 = 2
            r21 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r16, r17, r18, r19, r20, r21)
            if (r38 == 0) goto L_0x0074
            java.util.List r0 = walkFileTreeAndSkipEmptyFiles(r35)
            goto L_0x0078
        L_0x0074:
            java.util.List r0 = walkFileTree(r35, r36)
        L_0x0078:
            r16 = r0
            boolean r0 = r16.isEmpty()
            if (r0 == 0) goto L_0x00d8
            com.anggrayudi.storage.file.CreateMode r0 = r8.toCreateMode()
            androidx.documentfile.provider.DocumentFile r0 = makeFolder(r10, r12, r15, r0)
            if (r0 != 0) goto L_0x00ae
            kotlinx.coroutines.CoroutineScope r0 = r41.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            r2 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$postToUi$3 r3 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$postToUi$3
            r3.<init>(r11, r13)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = 2
            r5 = 0
            r35 = r0
            r36 = r1
            r37 = r2
            r38 = r3
            r39 = r4
            r40 = r5
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r35, r36, r37, r38, r39, r40)
            goto L_0x00d7
        L_0x00ae:
            if (r40 == 0) goto L_0x00b3
            r35.delete()
        L_0x00b3:
            kotlinx.coroutines.CoroutineScope r1 = r41.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            r3 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$postToUi$4 r4 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$postToUi$4
            r4.<init>(r11, r13, r0)
            r0 = r4
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r4 = 2
            r5 = 0
            r35 = r1
            r36 = r2
            r37 = r3
            r38 = r0
            r39 = r4
            r40 = r5
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r35, r36, r37, r38, r39, r40)
        L_0x00d7:
            return
        L_0x00d8:
            kotlin.jvm.internal.Ref$IntRef r7 = new kotlin.jvm.internal.Ref$IntRef
            r7.<init>()
            kotlin.jvm.internal.Ref$LongRef r5 = new kotlin.jvm.internal.Ref$LongRef
            r5.<init>()
            r0 = r16
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x00ea:
            boolean r1 = r0.hasNext()
            r4 = 1
            if (r1 == 0) goto L_0x010d
            java.lang.Object r1 = r0.next()
            androidx.documentfile.provider.DocumentFile r1 = (androidx.documentfile.provider.DocumentFile) r1
            boolean r2 = r1.isFile()
            if (r2 == 0) goto L_0x00ea
            int r2 = r7.element
            int r2 = r2 + r4
            r7.element = r2
            long r2 = r5.element
            long r17 = r1.length()
            long r2 = r2 + r17
            r5.element = r2
            goto L_0x00ea
        L_0x010d:
            java.lang.Thread r17 = java.lang.Thread.currentThread()
            boolean r0 = r17.isInterrupted()
            if (r0 == 0) goto L_0x013b
            kotlinx.coroutines.CoroutineScope r0 = r41.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            r2 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$postToUi$5 r3 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$postToUi$5
            r3.<init>(r11, r13)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = 2
            r5 = 0
            r35 = r0
            r36 = r1
            r37 = r2
            r38 = r3
            r39 = r4
            r40 = r5
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r35, r36, r37, r38, r39, r40)
            return
        L_0x013b:
            if (r40 == 0) goto L_0x01a3
            r1 = r35
            r2 = r36
            r3 = r10
            r4 = r15
            r23 = r5
            r5 = r38
            r6 = r39
            r11 = r7
            r7 = r8
            java.lang.Object r0 = tryMoveFolderByRenamingPath(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0 instanceof androidx.documentfile.provider.DocumentFile
            if (r1 == 0) goto L_0x0179
            kotlinx.coroutines.CoroutineScope r1 = r41.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            r3 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$postToUi$6 r4 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$postToUi$6
            r5 = 0
            r4.<init>(r5, r13, r0, r11)
            r0 = r4
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r4 = 2
            r5 = 0
            r35 = r1
            r36 = r2
            r37 = r3
            r38 = r0
            r39 = r4
            r40 = r5
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r35, r36, r37, r38, r39, r40)
            return
        L_0x0179:
            boolean r1 = r0 instanceof com.anggrayudi.storage.callback.FolderCallback.ErrorCode
            if (r1 == 0) goto L_0x01a6
            kotlinx.coroutines.CoroutineScope r1 = r41.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            r3 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$postToUi$7 r4 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$postToUi$7
            r5 = 0
            r4.<init>(r5, r13, r0)
            r0 = r4
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r4 = 2
            r5 = 0
            r35 = r1
            r36 = r2
            r37 = r3
            r38 = r0
            r39 = r4
            r40 = r5
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r35, r36, r37, r38, r39, r40)
            return
        L_0x01a3:
            r23 = r5
            r11 = r7
        L_0x01a6:
            java.lang.String r0 = getStorageId(r10, r12)     // Catch:{ all -> 0x0545 }
            long r0 = com.anggrayudi.storage.file.DocumentFileCompat.getFreeSpace(r12, r0)     // Catch:{ all -> 0x0545 }
            r7 = r23
            long r2 = r7.element     // Catch:{ all -> 0x0545 }
            boolean r0 = r13.onCheckFreeSpace(r0, r2)     // Catch:{ all -> 0x0545 }
            if (r0 != 0) goto L_0x01e0
            kotlinx.coroutines.CoroutineScope r0 = r41.getUiScope()     // Catch:{ all -> 0x0545 }
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()     // Catch:{ all -> 0x0545 }
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1     // Catch:{ all -> 0x0545 }
            r2 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$postToUi$8 r3 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$postToUi$8     // Catch:{ all -> 0x0545 }
            r4 = 0
            r3.<init>(r4, r13)     // Catch:{ all -> 0x01dd }
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3     // Catch:{ all -> 0x0545 }
            r4 = 2
            r5 = 0
            r35 = r0
            r36 = r1
            r37 = r2
            r38 = r3
            r39 = r4
            r40 = r5
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r35, r36, r37, r38, r39, r40)     // Catch:{ all -> 0x0545 }
            return
        L_0x01dd:
            r12 = r4
            goto L_0x0546
        L_0x01e0:
            kotlinx.coroutines.CoroutineScope r1 = r41.getUiScope()
            com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$awaitUiResult$1 r19 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$awaitUiResult$1
            r2 = 0
            r0 = r19
            r3 = r41
            r4 = r35
            r5 = r11
            r6 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = r19
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = 0
            r6 = 1
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(r1, r0, r6, r1)
            java.lang.Number r0 = (java.lang.Number) r0
            long r1 = r0.longValue()
            r19 = 0
            int r0 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            if (r0 >= 0) goto L_0x020a
            return
        L_0x020a:
            com.anggrayudi.storage.file.CreateMode r0 = r8.toCreateMode()
            androidx.documentfile.provider.DocumentFile r8 = makeFolder(r10, r12, r15, r0)
            if (r8 != 0) goto L_0x0239
            kotlinx.coroutines.CoroutineScope r0 = r41.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            r2 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$postToUi$10 r3 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$postToUi$10
            r5 = 0
            r3.<init>(r5, r13)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = 2
            r5 = 0
            r35 = r0
            r36 = r1
            r37 = r2
            r38 = r3
            r39 = r4
            r40 = r5
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r35, r36, r37, r38, r39, r40)
            return
        L_0x0239:
            r5 = 0
            kotlin.jvm.internal.Ref$IntRef r4 = new kotlin.jvm.internal.Ref$IntRef
            r4.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
            r3.<init>()
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            kotlin.jvm.internal.Ref$IntRef r17 = new kotlin.jvm.internal.Ref$IntRef
            r17.<init>()
            com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$startTimer$1 r18 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$startTimer$1
            r0 = r18
            r37 = r3
            r38 = r4
            r4 = r9
            r21 = r5
            r5 = r7
            r22 = r14
            r14 = 1
            r6 = r17
            r14 = r7
            r7 = r38
            r39 = r8
            r8 = r41
            r0.<init>(r1, r3, r4, r5, r6, r7, r8)
            r8 = r18
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            long r0 = r14.element
            r24 = 10485760(0xa00000, double:5.180654E-317)
            r7 = 0
            int r2 = (r0 > r24 ? 1 : (r0 == r24 ? 0 : -1))
            if (r2 <= 0) goto L_0x0279
            r4 = 1
            goto L_0x027a
        L_0x0279:
            r4 = 0
        L_0x027a:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)
            r8.invoke(r0)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            kotlin.jvm.internal.Ref$BooleanRef r1 = new kotlin.jvm.internal.Ref$BooleanRef
            r1.<init>()
            com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$notifyCanceled$1 r18 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$notifyCanceled$1
            r0 = r18
            r2 = r37
            r3 = r6
            r4 = r41
            r5 = r39
            r26 = r14
            r14 = r6
            r6 = r11
            r27 = r14
            r14 = 0
            r7 = r38
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r7 = r18
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = getAbsolutePath(r10, r12)
            r0.append(r1)
            r10 = 47
            r0.append(r10)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            java.util.ArrayList r15 = new java.util.ArrayList
            int r1 = r11.element
            r15.<init>(r1)
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r1]
            kotlin.jvm.internal.Ref$BooleanRef r5 = new kotlin.jvm.internal.Ref$BooleanRef
            r5.<init>()
            r1 = 1
            r5.element = r1
            com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$copy$1 r18 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$copy$1
            r1 = r18
            r2 = r36
            r3 = r41
            r4 = r38
            r14 = r5
            r5 = r40
            r10 = r7
            r7 = r9
            r28 = r8
            r8 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r8 = r18
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$handleError$1 r1 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$handleError$1
            r2 = r37
            r1.<init>(r10, r2, r13)
            r7 = r1
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.util.Iterator r1 = r16.iterator()
        L_0x02f9:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x03d9
            java.lang.Object r3 = r1.next()
            androidx.documentfile.provider.DocumentFile r3 = (androidx.documentfile.provider.DocumentFile) r3
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x03c1 }
            boolean r4 = r4.isInterrupted()     // Catch:{ Exception -> 0x03c1 }
            if (r4 == 0) goto L_0x0315
            com.anggrayudi.storage.callback.FolderCallback$ErrorCode r0 = com.anggrayudi.storage.callback.FolderCallback.ErrorCode.CANCELED     // Catch:{ Exception -> 0x03c1 }
            r10.invoke(r0)     // Catch:{ Exception -> 0x03c1 }
            return
        L_0x0315:
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x03c1 }
            if (r4 != 0) goto L_0x031c
            goto L_0x02f9
        L_0x031c:
            java.lang.String r4 = getSubPath(r3, r12, r0)     // Catch:{ Exception -> 0x03c1 }
            r6 = r22
            r5 = 47
            java.lang.String r4 = kotlin.text.StringsKt.substringBeforeLast((java.lang.String) r4, (char) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x03bd }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03bd }
            r5.<init>()     // Catch:{ Exception -> 0x03bd }
            r5.append(r4)     // Catch:{ Exception -> 0x03bd }
            r4 = 47
            r5.append(r4)     // Catch:{ Exception -> 0x03bd }
            java.lang.String r16 = r3.getName()     // Catch:{ Exception -> 0x03bd }
            if (r16 != 0) goto L_0x033d
            r4 = r6
            goto L_0x033f
        L_0x033d:
            r4 = r16
        L_0x033f:
            r5.append(r4)     // Catch:{ Exception -> 0x03bd }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x03bd }
            java.lang.String r4 = com.anggrayudi.storage.extension.TextUtils.trimFileSeparator(r4)     // Catch:{ Exception -> 0x03bd }
            boolean r5 = r3.isDirectory()     // Catch:{ Exception -> 0x03bd }
            if (r5 == 0) goto L_0x0364
            com.anggrayudi.storage.file.CreateMode r3 = com.anggrayudi.storage.file.CreateMode.REUSE     // Catch:{ Exception -> 0x03bd }
            r5 = r39
            androidx.documentfile.provider.DocumentFile r3 = makeFolder(r5, r12, r4, r3)     // Catch:{ Exception -> 0x03bb }
            if (r3 != 0) goto L_0x035f
            r3 = 0
            r14.element = r3     // Catch:{ Exception -> 0x03bb }
            goto L_0x03dd
        L_0x035f:
            r39 = r5
            r22 = r6
            goto L_0x02f9
        L_0x0364:
            r5 = r39
            r37 = r0
            java.lang.String r0 = r3.getType()     // Catch:{ Exception -> 0x03bb }
            r39 = r1
            com.anggrayudi.storage.file.CreateMode r1 = com.anggrayudi.storage.file.CreateMode.REUSE     // Catch:{ Exception -> 0x03bb }
            androidx.documentfile.provider.DocumentFile r0 = makeFile(r5, r12, r4, r0, r1)     // Catch:{ Exception -> 0x03bb }
            r4 = r27
            r4.element = r0     // Catch:{ Exception -> 0x03b9 }
            T r0 = r4.element     // Catch:{ Exception -> 0x03b9 }
            if (r0 == 0) goto L_0x03a1
            T r0 = r4.element     // Catch:{ Exception -> 0x03b9 }
            androidx.documentfile.provider.DocumentFile r0 = (androidx.documentfile.provider.DocumentFile) r0     // Catch:{ Exception -> 0x03b9 }
            long r0 = r0.length()     // Catch:{ Exception -> 0x03b9 }
            int r16 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r16 <= 0) goto L_0x03a1
            com.anggrayudi.storage.callback.FolderCallback$FileConflict r0 = new com.anggrayudi.storage.callback.FolderCallback$FileConflict     // Catch:{ Exception -> 0x03b9 }
            T r1 = r4.element     // Catch:{ Exception -> 0x03b9 }
            r31 = r1
            androidx.documentfile.provider.DocumentFile r31 = (androidx.documentfile.provider.DocumentFile) r31     // Catch:{ Exception -> 0x03b9 }
            r32 = 0
            r33 = 4
            r34 = 0
            r29 = r0
            r30 = r3
            r29.<init>(r30, r31, r32, r33, r34)     // Catch:{ Exception -> 0x03b9 }
            r15.add(r0)     // Catch:{ Exception -> 0x03b9 }
            goto L_0x03b2
        L_0x03a1:
            T r0 = r4.element     // Catch:{ Exception -> 0x03b9 }
            if (r0 != 0) goto L_0x03ab
            com.anggrayudi.storage.callback.FolderCallback$ErrorCode r0 = com.anggrayudi.storage.callback.FolderCallback.ErrorCode.CANNOT_CREATE_FILE_IN_TARGET     // Catch:{ Exception -> 0x03b9 }
            r10.invoke(r0)     // Catch:{ Exception -> 0x03b9 }
            return
        L_0x03ab:
            T r0 = r4.element     // Catch:{ Exception -> 0x03b9 }
            r8.invoke(r3, r0)     // Catch:{ Exception -> 0x03b9 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x03b2:
            r0 = r37
            r1 = r39
            r27 = r4
            goto L_0x035f
        L_0x03b9:
            r0 = move-exception
            goto L_0x03c8
        L_0x03bb:
            r0 = move-exception
            goto L_0x03c6
        L_0x03bd:
            r0 = move-exception
            r5 = r39
            goto L_0x03c6
        L_0x03c1:
            r0 = move-exception
            r5 = r39
            r6 = r22
        L_0x03c6:
            r4 = r27
        L_0x03c8:
            java.lang.Object r0 = r7.invoke(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x03d5
            return
        L_0x03d5:
            r1 = 0
            r14.element = r1
            goto L_0x03df
        L_0x03d9:
            r5 = r39
            r6 = r22
        L_0x03dd:
            r4 = r27
        L_0x03df:
            com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$finalize$1 r0 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$finalize$1
            r1 = r0
            r3 = r14
            r12 = r4
            r4 = r15
            r16 = r5
            r5 = r40
            r17 = r6
            r6 = r35
            r13 = r7
            r7 = r36
            r18 = r14
            r14 = r8
            r8 = r41
            r19 = r13
            r13 = r9
            r9 = r16
            r20 = r14
            r14 = r10
            r10 = r11
            r27 = r12
            r12 = r21
            r11 = r38
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r8 = r0
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            java.lang.Object r0 = r8.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0417
            return
        L_0x0417:
            kotlinx.coroutines.CoroutineScope r1 = r41.getUiScope()
            com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$awaitUiResultWithPending$1 r6 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$awaitUiResultWithPending$1
            r2 = 0
            r0 = r6
            r3 = r41
            r4 = r16
            r5 = r15
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r1 = 1
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(r12, r6, r1, r12)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x043b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0477
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.anggrayudi.storage.callback.FolderCallback$FileConflict r3 = (com.anggrayudi.storage.callback.FolderCallback.FileConflict) r3
            com.anggrayudi.storage.callback.FileCallback$ConflictResolution r4 = r3.getSolution()
            com.anggrayudi.storage.callback.FileCallback$ConflictResolution r5 = com.anggrayudi.storage.callback.FileCallback.ConflictResolution.SKIP
            if (r4 != r5) goto L_0x0462
            if (r40 == 0) goto L_0x0459
            androidx.documentfile.provider.DocumentFile r4 = r3.getSource()
            r4.delete()
        L_0x0459:
            r4 = r38
            int r5 = r4.element
            r6 = 1
            int r5 = r5 + r6
            r4.element = r5
            goto L_0x0464
        L_0x0462:
            r4 = r38
        L_0x0464:
            com.anggrayudi.storage.callback.FileCallback$ConflictResolution r3 = r3.getSolution()
            com.anggrayudi.storage.callback.FileCallback$ConflictResolution r5 = com.anggrayudi.storage.callback.FileCallback.ConflictResolution.SKIP
            if (r3 == r5) goto L_0x046e
            r3 = 1
            goto L_0x046f
        L_0x046e:
            r3 = 0
        L_0x046f:
            if (r3 == 0) goto L_0x0474
            r1.add(r2)
        L_0x0474:
            r38 = r4
            goto L_0x043b
        L_0x0477:
            java.util.List r1 = (java.util.List) r1
            r2 = r26
            long r2 = r2.element
            long r4 = r13.element
            long r2 = r2 - r4
            r0 = r1
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r9 = 1
            r0 = r0 ^ r9
            if (r0 == 0) goto L_0x0491
            int r0 = (r2 > r24 ? 1 : (r2 == r24 ? 0 : -1))
            if (r0 <= 0) goto L_0x0491
            r4 = 1
            goto L_0x0492
        L_0x0491:
            r4 = 0
        L_0x0492:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)
            r2 = r28
            r2.invoke(r0)
            java.util.Iterator r0 = r1.iterator()
        L_0x049f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0541
            java.lang.Object r1 = r0.next()
            r10 = r1
            com.anggrayudi.storage.callback.FolderCallback$FileConflict r10 = (com.anggrayudi.storage.callback.FolderCallback.FileConflict) r10
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            boolean r1 = r1.isInterrupted()
            if (r1 == 0) goto L_0x04bc
            com.anggrayudi.storage.callback.FolderCallback$ErrorCode r0 = com.anggrayudi.storage.callback.FolderCallback.ErrorCode.CANCELED
            r14.invoke(r0)
            return
        L_0x04bc:
            androidx.documentfile.provider.DocumentFile r1 = r10.getSource()
            boolean r1 = r1.isFile()
            if (r1 != 0) goto L_0x04c7
            goto L_0x049f
        L_0x04c7:
            androidx.documentfile.provider.DocumentFile r1 = r10.getTarget()
            java.lang.String r1 = r1.getName()
            if (r1 != 0) goto L_0x04d4
            r3 = r17
            goto L_0x04d5
        L_0x04d4:
            r3 = r1
        L_0x04d5:
            com.anggrayudi.storage.callback.FileCallback$ConflictResolution r1 = r10.getSolution()
            com.anggrayudi.storage.callback.FileCallback$ConflictResolution r2 = com.anggrayudi.storage.callback.FileCallback.ConflictResolution.REPLACE
            if (r1 != r2) goto L_0x04f4
            androidx.documentfile.provider.DocumentFile r1 = r10.getTarget()
            boolean r2 = r1.delete()
            if (r2 == 0) goto L_0x04f0
            boolean r1 = r1.exists()
            if (r1 == 0) goto L_0x04ee
            goto L_0x04f0
        L_0x04ee:
            r4 = 0
            goto L_0x04f1
        L_0x04f0:
            r4 = 1
        L_0x04f1:
            if (r4 == 0) goto L_0x04f4
            goto L_0x049f
        L_0x04f4:
            androidx.documentfile.provider.DocumentFile r1 = r10.getTarget()
            androidx.documentfile.provider.DocumentFile r1 = r1.getParentFile()
            if (r1 != 0) goto L_0x0500
            r11 = r12
            goto L_0x050b
        L_0x0500:
            r4 = 0
            r5 = 0
            r6 = 12
            r7 = 0
            r2 = r36
            androidx.documentfile.provider.DocumentFile r11 = makeFile$default(r1, r2, r3, r4, r5, r6, r7)
        L_0x050b:
            r1 = r27
            r1.element = r11
            T r2 = r1.element
            if (r2 != 0) goto L_0x0519
            com.anggrayudi.storage.callback.FolderCallback$ErrorCode r0 = com.anggrayudi.storage.callback.FolderCallback.ErrorCode.CANNOT_CREATE_FILE_IN_TARGET
            r14.invoke(r0)
            return
        L_0x0519:
            androidx.documentfile.provider.DocumentFile r2 = r10.getSource()     // Catch:{ Exception -> 0x052c }
            T r3 = r1.element     // Catch:{ Exception -> 0x052c }
            r4 = r20
            r4.invoke(r2, r3)     // Catch:{ Exception -> 0x052c }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            r27 = r1
            r20 = r4
            goto L_0x049f
        L_0x052c:
            r0 = move-exception
            r1 = r19
            java.lang.Object r0 = r1.invoke(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x053c
            return
        L_0x053c:
            r1 = r18
            r2 = 0
            r1.element = r2
        L_0x0541:
            r8.invoke()
            return
        L_0x0545:
            r12 = 0
        L_0x0546:
            kotlinx.coroutines.CoroutineScope r0 = r41.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            r2 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$postToUi$9 r3 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$postToUi$9
            r4 = r41
            r3.<init>(r12, r4)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = 2
            r5 = 0
            r35 = r0
            r36 = r1
            r37 = r2
            r38 = r3
            r39 = r4
            r40 = r5
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r35, r36, r37, r38, r39, r40)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileUtils.copyFolderTo(androidx.documentfile.provider.DocumentFile, android.content.Context, androidx.documentfile.provider.DocumentFile, boolean, java.lang.String, boolean, com.anggrayudi.storage.callback.FolderCallback):void");
    }

    /* access modifiers changed from: private */
    public static final FolderCallback.ErrorCode toFolderCallbackErrorCode(Exception exc) {
        if (exc instanceof SecurityException) {
            return FolderCallback.ErrorCode.STORAGE_PERMISSION_DENIED;
        }
        if (exc instanceof InterruptedIOException ? true : exc instanceof InterruptedException) {
            return FolderCallback.ErrorCode.CANCELED;
        }
        return FolderCallback.ErrorCode.UNKNOWN_IO_ERROR;
    }

    /* access modifiers changed from: private */
    public static final MultipleFileCallback.ErrorCode toMultipleFileCallbackErrorCode(Exception exc) {
        if (exc instanceof SecurityException) {
            return MultipleFileCallback.ErrorCode.STORAGE_PERMISSION_DENIED;
        }
        if (exc instanceof InterruptedIOException ? true : exc instanceof InterruptedException) {
            return MultipleFileCallback.ErrorCode.CANCELED;
        }
        return MultipleFileCallback.ErrorCode.UNKNOWN_IO_ERROR;
    }

    private static final DocumentFile doesMeetCopyRequirements(DocumentFile documentFile, Context context, DocumentFile documentFile2, String str, FolderCallback folderCallback) {
        Context context2 = context;
        DocumentFile documentFile3 = documentFile2;
        String str2 = str;
        FolderCallback folderCallback2 = folderCallback;
        Job unused = BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$7((Continuation) null, folderCallback2), 2, (Object) null);
        if (!documentFile.isDirectory()) {
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$8((Continuation) null, folderCallback2), 2, (Object) null);
            return null;
        } else if (!documentFile2.isDirectory()) {
            Job unused3 = BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$9((Continuation) null, folderCallback2), 2, (Object) null);
            return null;
        } else if (!documentFile.canRead() || !isWritable(documentFile3, context2)) {
            Job unused4 = BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$10((Continuation) null, folderCallback2), 2, (Object) null);
            return null;
        } else {
            String absolutePath = getAbsolutePath(documentFile3, context2);
            DocumentFile parentFile = documentFile.getParentFile();
            if (Intrinsics.areEqual((Object) absolutePath, (Object) parentFile == null ? null : getAbsolutePath(parentFile, context2))) {
                CharSequence charSequence = str2;
                if ((charSequence == null || charSequence.length() == 0) || Intrinsics.areEqual((Object) documentFile.getName(), (Object) str2)) {
                    Job unused5 = BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$11((Continuation) null, folderCallback2), 2, (Object) null);
                    return null;
                }
            }
            DocumentFile writableDownloadsDocumentFile = isDownloadsDocument(documentFile2) ? toWritableDownloadsDocumentFile(documentFile3, context2) : documentFile3;
            if (writableDownloadsDocumentFile == null) {
                Job unused6 = BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$12((Continuation) null, folderCallback2), 2, (Object) null);
            }
            return writableDownloadsDocumentFile;
        }
    }

    public static /* synthetic */ void copyFileTo$default(DocumentFile documentFile, Context context, File file, FileDescription fileDescription, FileCallback fileCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            fileDescription = null;
        }
        copyFileTo(documentFile, context, file, fileDescription, fileCallback);
    }

    public static final void copyFileTo(DocumentFile documentFile, Context context, File file, FileDescription fileDescription, FileCallback fileCallback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "targetFolder");
        Intrinsics.checkNotNullParameter(fileCallback, "callback");
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "targetFolder.absolutePath");
        copyFileTo(documentFile, context, absolutePath, fileDescription, fileCallback);
    }

    public static /* synthetic */ void copyFileTo$default(DocumentFile documentFile, Context context, String str, FileDescription fileDescription, FileCallback fileCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            fileDescription = null;
        }
        copyFileTo(documentFile, context, str, fileDescription, fileCallback);
    }

    public static final void copyFileTo(DocumentFile documentFile, Context context, String str, FileDescription fileDescription, FileCallback fileCallback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "targetFolderAbsolutePath");
        Intrinsics.checkNotNullParameter(fileCallback, "callback");
        DocumentFile mkdirs$default = DocumentFileCompat.mkdirs$default(context, str, true, false, 8, (Object) null);
        if (mkdirs$default == null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$copyFileTo$$inlined$postToUi$1((Continuation) null, fileCallback), 2, (Object) null);
        } else {
            copyFileTo(documentFile, context, mkdirs$default, fileDescription, fileCallback);
        }
    }

    public static /* synthetic */ void copyFileTo$default(DocumentFile documentFile, Context context, DocumentFile documentFile2, FileDescription fileDescription, FileCallback fileCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            fileDescription = null;
        }
        copyFileTo(documentFile, context, documentFile2, fileDescription, fileCallback);
    }

    public static final void copyFileTo(DocumentFile documentFile, Context context, DocumentFile documentFile2, FileDescription fileDescription, FileCallback fileCallback) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(documentFile2, "targetFolder");
        Intrinsics.checkNotNullParameter(fileCallback, "callback");
        String str3 = null;
        CharSequence subFolder = fileDescription == null ? null : fileDescription.getSubFolder();
        if (subFolder == null || subFolder.length() == 0) {
            if (fileDescription == null) {
                str2 = null;
            } else {
                str2 = fileDescription.getName();
            }
            if (fileDescription != null) {
                str3 = fileDescription.getMimeType();
            }
            copyFileTo(documentFile, context, documentFile2, str2, str3, fileCallback);
            return;
        }
        if (fileDescription == null) {
            str = null;
        } else {
            str = fileDescription.getSubFolder();
        }
        if (str == null) {
            str = "";
        }
        DocumentFile makeFolder = makeFolder(documentFile2, context, str, CreateMode.REUSE);
        if (makeFolder == null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$copyFileTo$$inlined$postToUi$2((Continuation) null, fileCallback), 2, (Object) null);
            return;
        }
        String name = fileDescription == null ? null : fileDescription.getName();
        if (fileDescription != null) {
            str3 = fileDescription.getMimeType();
        }
        copyFileTo(documentFile, context, makeFolder, name, str3, fileCallback);
    }

    private static final void copyFileTo(DocumentFile documentFile, Context context, DocumentFile documentFile2, String str, String str2, FileCallback fileCallback) {
        String str3;
        DocumentFile documentFile3 = documentFile;
        Context context2 = context;
        String str4 = str;
        FileCallback fileCallback2 = fileCallback;
        DocumentFile doesMeetCopyRequirements = doesMeetCopyRequirements(documentFile3, context2, documentFile2, str4, fileCallback2);
        if (doesMeetCopyRequirements != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$copyFileTo$$inlined$postToUi$3((Continuation) null, fileCallback2), 2, (Object) null);
            try {
                if (!fileCallback2.onCheckFreeSpace(DocumentFileCompat.getFreeSpace(context2, getStorageId(doesMeetCopyRequirements, context2)), documentFile.length())) {
                    Job unused2 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$copyFileTo$$inlined$postToUi$4((Continuation) null, fileCallback2), 2, (Object) null);
                    return;
                }
                DocumentFileCompat documentFileCompat = DocumentFileCompat.INSTANCE;
                if (str4 == null && (str4 = documentFile.getName()) == null) {
                    str4 = "";
                }
                String trimFileSeparator = TextUtils.trimFileSeparator(documentFileCompat.removeForbiddenCharsFromFilename$storage_release(MimeType.getFullFileName(str4, str2 == null ? getMimeTypeByFileName(documentFile) : str2)));
                FileCallback.ConflictResolution handleFileConflict = handleFileConflict(context2, doesMeetCopyRequirements, trimFileSeparator, fileCallback2);
                if (handleFileConflict != FileCallback.ConflictResolution.SKIP) {
                    long longValue = ((Number) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new DocumentFileUtils$copyFileTo$$inlined$awaitUiResult$1(fileCallback.getUiScope(), (Continuation) null, fileCallback, documentFile, Thread.currentThread()), 1, (Object) null)).longValue();
                    int i = (longValue > 0 ? 1 : (longValue == 0 ? 0 : -1));
                    if (i >= 0) {
                        boolean z = i > 0;
                        if (str2 == null) {
                            try {
                                str3 = getMimeTypeByFileName(documentFile);
                            } catch (Exception e) {
                                Job unused3 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$copyFileTo$$inlined$postToUi$6((Continuation) null, fileCallback2, e), 2, (Object) null);
                                return;
                            }
                        } else {
                            str3 = str2;
                        }
                        DocumentFile createTargetFile = createTargetFile(context, doesMeetCopyRequirements, trimFileSeparator, str3, handleFileConflict.toCreateMode(), fileCallback);
                        if (createTargetFile != null) {
                            createFileStreams(context2, documentFile3, createTargetFile, fileCallback2, (Function2<? super InputStream, ? super OutputStream, Unit>) new DocumentFileUtils$copyFileTo$6(documentFile, createTargetFile, z, longValue, fileCallback));
                        }
                    }
                }
            } catch (Throwable unused4) {
                Job unused5 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$copyFileTo$$inlined$postToUi$5((Continuation) null, fileCallback2), 2, (Object) null);
            }
        }
    }

    private static final DocumentFile doesMeetCopyRequirements(DocumentFile documentFile, Context context, DocumentFile documentFile2, String str, FileCallback fileCallback) {
        Context context2 = context;
        DocumentFile documentFile3 = documentFile2;
        String str2 = str;
        FileCallback fileCallback2 = fileCallback;
        Job unused = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$13((Continuation) null, fileCallback2), 2, (Object) null);
        if (!documentFile.isFile()) {
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$14((Continuation) null, fileCallback2), 2, (Object) null);
            return null;
        } else if (!documentFile2.isDirectory()) {
            Job unused3 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$15((Continuation) null, fileCallback2), 2, (Object) null);
            return null;
        } else if (!documentFile.canRead() || !isWritable(documentFile3, context2)) {
            Job unused4 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$16((Continuation) null, fileCallback2), 2, (Object) null);
            return null;
        } else {
            DocumentFile parentFile = documentFile.getParentFile();
            if (Intrinsics.areEqual((Object) parentFile == null ? null : getAbsolutePath(parentFile, context2), (Object) getAbsolutePath(documentFile3, context2))) {
                CharSequence charSequence = str2;
                if ((charSequence == null || charSequence.length() == 0) || Intrinsics.areEqual((Object) documentFile.getName(), (Object) str2)) {
                    Job unused5 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$17((Continuation) null, fileCallback2), 2, (Object) null);
                    return null;
                }
            }
            DocumentFile writableDownloadsDocumentFile = isDownloadsDocument(documentFile2) ? toWritableDownloadsDocumentFile(documentFile3, context2) : documentFile3;
            if (writableDownloadsDocumentFile == null) {
                Job unused6 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$18((Continuation) null, fileCallback2), 2, (Object) null);
            }
            return writableDownloadsDocumentFile;
        }
    }

    /* access modifiers changed from: private */
    public static final <Enum> void createFileStreams(Context context, DocumentFile documentFile, DocumentFile documentFile2, BaseFileCallback<Enum, ?, ?> baseFileCallback, Function2<? super InputStream, ? super OutputStream, Unit> function2) {
        Enum enumR;
        Enum enumR2;
        OutputStream openOutputStream$default = openOutputStream$default(documentFile2, context, false, 2, (Object) null);
        if (openOutputStream$default == null) {
            if (baseFileCallback instanceof MultipleFileCallback) {
                enumR2 = MultipleFileCallback.ErrorCode.CANNOT_CREATE_FILE_IN_TARGET;
            } else if (baseFileCallback instanceof FolderCallback) {
                enumR2 = FolderCallback.ErrorCode.CANNOT_CREATE_FILE_IN_TARGET;
            } else {
                enumR2 = FileCallback.ErrorCode.TARGET_FILE_NOT_FOUND;
            }
            Job unused = BuildersKt__Builders_commonKt.launch$default(baseFileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$createFileStreams$$inlined$postToUi$1((Continuation) null, baseFileCallback, enumR2), 2, (Object) null);
            return;
        }
        InputStream openInputStream = openInputStream(documentFile, context);
        if (openInputStream == null) {
            IOUtils.closeStream(openOutputStream$default);
            if (baseFileCallback instanceof MultipleFileCallback) {
                enumR = MultipleFileCallback.ErrorCode.SOURCE_FILE_NOT_FOUND;
            } else if (baseFileCallback instanceof FolderCallback) {
                enumR = FolderCallback.ErrorCode.SOURCE_FILE_NOT_FOUND;
            } else {
                enumR = FileCallback.ErrorCode.SOURCE_FILE_NOT_FOUND;
            }
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(baseFileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$createFileStreams$$inlined$postToUi$2((Continuation) null, baseFileCallback, enumR), 2, (Object) null);
            return;
        }
        function2.invoke(openInputStream, openOutputStream$default);
    }

    private static final void createFileStreams(Context context, DocumentFile documentFile, MediaFile mediaFile, FileCallback fileCallback, Function2<? super InputStream, ? super OutputStream, Unit> function2) {
        OutputStream openOutputStream$default = MediaFile.openOutputStream$default(mediaFile, false, 1, (Object) null);
        if (openOutputStream$default == null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$createFileStreams$$inlined$postToUi$3((Continuation) null, fileCallback), 2, (Object) null);
            return;
        }
        InputStream openInputStream = openInputStream(documentFile, context);
        if (openInputStream == null) {
            IOUtils.closeStream(openOutputStream$default);
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$createFileStreams$$inlined$postToUi$4((Continuation) null, fileCallback), 2, (Object) null);
            return;
        }
        function2.invoke(openInputStream, openOutputStream$default);
    }

    private static final DocumentFile createTargetFile(Context context, DocumentFile documentFile, String str, String str2, CreateMode createMode, FileCallback fileCallback) {
        DocumentFile makeFile = makeFile(documentFile, context, str, str2, createMode);
        if (makeFile == null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$createTargetFile$$inlined$postToUi$1((Continuation) null, fileCallback), 2, (Object) null);
        }
        return makeFile;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void copyFileStream(androidx.documentfile.provider.DocumentFile r22, java.io.InputStream r23, java.io.OutputStream r24, java.lang.Object r25, boolean r26, long r27, boolean r29, com.anggrayudi.storage.callback.FileCallback r30) {
        /*
            r1 = r23
            r0 = r25
            kotlin.jvm.internal.Ref$LongRef r10 = new kotlin.jvm.internal.Ref$LongRef     // Catch:{ all -> 0x00b1 }
            r10.<init>()     // Catch:{ all -> 0x00b1 }
            kotlin.jvm.internal.Ref$IntRef r11 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x00b1 }
            r11.<init>()     // Catch:{ all -> 0x00b1 }
            long r12 = r22.length()     // Catch:{ all -> 0x00b1 }
            if (r26 == 0) goto L_0x003a
            r4 = 10485760(0xa00000, double:5.180654E-317)
            int r6 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x003a
            r14 = 0
            r18 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyFileStream$1 r16 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFileStream$1     // Catch:{ all -> 0x00b1 }
            r4 = r16
            r5 = r10
            r6 = r12
            r8 = r11
            r9 = r30
            r4.<init>(r5, r6, r8, r9)     // Catch:{ all -> 0x00b1 }
            r19 = r16
            kotlin.jvm.functions.Function0 r19 = (kotlin.jvm.functions.Function0) r19     // Catch:{ all -> 0x00b1 }
            r20 = 5
            r21 = 0
            r16 = r27
            kotlinx.coroutines.Job r4 = com.anggrayudi.storage.extension.CoroutineExtKt.startCoroutineTimer$default(r14, r16, r18, r19, r20, r21)     // Catch:{ all -> 0x00b1 }
            goto L_0x003b
        L_0x003a:
            r4 = 0
        L_0x003b:
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x00ad }
            int r6 = r1.read(r5)     // Catch:{ all -> 0x00ad }
        L_0x0043:
            r7 = -1
            if (r6 == r7) goto L_0x005e
            r7 = 0
            r8 = r24
            r8.write(r5, r7, r6)     // Catch:{ all -> 0x005c }
            long r14 = r10.element     // Catch:{ all -> 0x005c }
            long r2 = (long) r6     // Catch:{ all -> 0x005c }
            long r14 = r14 + r2
            r10.element = r14     // Catch:{ all -> 0x005c }
            int r2 = r11.element     // Catch:{ all -> 0x005c }
            int r2 = r2 + r6
            r11.element = r2     // Catch:{ all -> 0x005c }
            int r6 = r1.read(r5)     // Catch:{ all -> 0x005c }
            goto L_0x0043
        L_0x005c:
            r0 = move-exception
            goto L_0x00b5
        L_0x005e:
            r8 = r24
            if (r4 != 0) goto L_0x0063
            goto L_0x0068
        L_0x0063:
            r2 = 1
            r3 = 0
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r4, (java.util.concurrent.CancellationException) r3, (int) r2, (java.lang.Object) r3)     // Catch:{ all -> 0x005c }
        L_0x0068:
            if (r29 == 0) goto L_0x006d
            r22.delete()     // Catch:{ all -> 0x005c }
        L_0x006d:
            boolean r2 = r0 instanceof com.anggrayudi.storage.media.MediaFile     // Catch:{ all -> 0x005c }
            if (r2 == 0) goto L_0x0077
            r2 = r0
            com.anggrayudi.storage.media.MediaFile r2 = (com.anggrayudi.storage.media.MediaFile) r2     // Catch:{ all -> 0x005c }
            r2.setLength(r12)     // Catch:{ all -> 0x005c }
        L_0x0077:
            kotlinx.coroutines.CoroutineScope r2 = r30.getUiScope()     // Catch:{ all -> 0x005c }
            kotlinx.coroutines.MainCoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.getMain()     // Catch:{ all -> 0x005c }
            kotlin.coroutines.CoroutineContext r3 = (kotlin.coroutines.CoroutineContext) r3     // Catch:{ all -> 0x005c }
            r5 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyFileStream$$inlined$postToUi$1 r6 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFileStream$$inlined$postToUi$1     // Catch:{ all -> 0x005c }
            r9 = r30
            r10 = 0
            r6.<init>(r10, r9, r0)     // Catch:{ all -> 0x005c }
            r0 = r6
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0     // Catch:{ all -> 0x005c }
            r6 = 2
            r10 = 0
            r25 = r2
            r26 = r3
            r27 = r5
            r28 = r0
            r29 = r6
            r30 = r10
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r25, r26, r27, r28, r29, r30)     // Catch:{ all -> 0x005c }
            if (r4 != 0) goto L_0x00a1
            goto L_0x00a6
        L_0x00a1:
            r2 = 1
            r3 = 0
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r4, (java.util.concurrent.CancellationException) r3, (int) r2, (java.lang.Object) r3)
        L_0x00a6:
            com.anggrayudi.storage.extension.IOUtils.closeStream((java.io.InputStream) r23)
            com.anggrayudi.storage.extension.IOUtils.closeStream((java.io.OutputStream) r24)
            return
        L_0x00ad:
            r0 = move-exception
            r8 = r24
            goto L_0x00b5
        L_0x00b1:
            r0 = move-exception
            r8 = r24
            r4 = 0
        L_0x00b5:
            if (r4 != 0) goto L_0x00b8
            goto L_0x00bd
        L_0x00b8:
            r2 = 1
            r3 = 0
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r4, (java.util.concurrent.CancellationException) r3, (int) r2, (java.lang.Object) r3)
        L_0x00bd:
            com.anggrayudi.storage.extension.IOUtils.closeStream((java.io.InputStream) r23)
            com.anggrayudi.storage.extension.IOUtils.closeStream((java.io.OutputStream) r24)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileUtils.copyFileStream(androidx.documentfile.provider.DocumentFile, java.io.InputStream, java.io.OutputStream, java.lang.Object, boolean, long, boolean, com.anggrayudi.storage.callback.FileCallback):void");
    }

    public static /* synthetic */ void moveFileTo$default(DocumentFile documentFile, Context context, File file, FileDescription fileDescription, FileCallback fileCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            fileDescription = null;
        }
        moveFileTo(documentFile, context, file, fileDescription, fileCallback);
    }

    public static final void moveFileTo(DocumentFile documentFile, Context context, File file, FileDescription fileDescription, FileCallback fileCallback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "targetFolder");
        Intrinsics.checkNotNullParameter(fileCallback, "callback");
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "targetFolder.absolutePath");
        moveFileTo(documentFile, context, absolutePath, fileDescription, fileCallback);
    }

    public static /* synthetic */ void moveFileTo$default(DocumentFile documentFile, Context context, String str, FileDescription fileDescription, FileCallback fileCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            fileDescription = null;
        }
        moveFileTo(documentFile, context, str, fileDescription, fileCallback);
    }

    public static final void moveFileTo(DocumentFile documentFile, Context context, String str, FileDescription fileDescription, FileCallback fileCallback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "targetFolderAbsolutePath");
        Intrinsics.checkNotNullParameter(fileCallback, "callback");
        DocumentFile mkdirs$default = DocumentFileCompat.mkdirs$default(context, str, true, false, 8, (Object) null);
        if (mkdirs$default == null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$moveFileTo$$inlined$postToUi$1((Continuation) null, fileCallback), 2, (Object) null);
        } else {
            moveFileTo(documentFile, context, mkdirs$default, fileDescription, fileCallback);
        }
    }

    public static /* synthetic */ void moveFileTo$default(DocumentFile documentFile, Context context, DocumentFile documentFile2, FileDescription fileDescription, FileCallback fileCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            fileDescription = null;
        }
        moveFileTo(documentFile, context, documentFile2, fileDescription, fileCallback);
    }

    public static final void moveFileTo(DocumentFile documentFile, Context context, DocumentFile documentFile2, FileDescription fileDescription, FileCallback fileCallback) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(documentFile2, "targetFolder");
        Intrinsics.checkNotNullParameter(fileCallback, "callback");
        String str3 = null;
        CharSequence subFolder = fileDescription == null ? null : fileDescription.getSubFolder();
        if (subFolder == null || subFolder.length() == 0) {
            if (fileDescription == null) {
                str2 = null;
            } else {
                str2 = fileDescription.getName();
            }
            if (fileDescription != null) {
                str3 = fileDescription.getMimeType();
            }
            moveFileTo(documentFile, context, documentFile2, str2, str3, fileCallback);
            return;
        }
        if (fileDescription == null) {
            str = null;
        } else {
            str = fileDescription.getSubFolder();
        }
        if (str == null) {
            str = "";
        }
        DocumentFile makeFolder = makeFolder(documentFile2, context, str, CreateMode.REUSE);
        if (makeFolder == null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$moveFileTo$$inlined$postToUi$2((Continuation) null, fileCallback), 2, (Object) null);
            return;
        }
        String name = fileDescription == null ? null : fileDescription.getName();
        if (fileDescription != null) {
            str3 = fileDescription.getMimeType();
        }
        moveFileTo(documentFile, context, makeFolder, name, str3, fileCallback);
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x0145 A[Catch:{ all -> 0x023c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void moveFileTo(androidx.documentfile.provider.DocumentFile r18, android.content.Context r19, androidx.documentfile.provider.DocumentFile r20, java.lang.String r21, java.lang.String r22, com.anggrayudi.storage.callback.FileCallback r23) {
        /*
            r0 = r18
            r8 = r19
            r1 = r21
            r2 = r20
            r9 = r23
            androidx.documentfile.provider.DocumentFile r7 = doesMeetCopyRequirements((androidx.documentfile.provider.DocumentFile) r0, (android.content.Context) r8, (androidx.documentfile.provider.DocumentFile) r2, (java.lang.String) r1, (com.anggrayudi.storage.callback.FileCallback) r9)
            if (r7 != 0) goto L_0x0011
            return
        L_0x0011:
            kotlinx.coroutines.CoroutineScope r10 = r23.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getMain()
            r11 = r2
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11
            r12 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$$inlined$postToUi$3 r2 = new com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$$inlined$postToUi$3
            r6 = 0
            r2.<init>(r6, r9)
            r13 = r2
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r14 = 2
            r15 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r10, r11, r12, r13, r14, r15)
            com.anggrayudi.storage.file.DocumentFileCompat r2 = com.anggrayudi.storage.file.DocumentFileCompat.INSTANCE
            if (r1 != 0) goto L_0x0038
            java.lang.String r3 = r18.getName()
            if (r3 != 0) goto L_0x0039
            java.lang.String r3 = ""
            goto L_0x0039
        L_0x0038:
            r3 = r1
        L_0x0039:
            if (r22 != 0) goto L_0x0040
            java.lang.String r4 = getMimeTypeByFileName(r18)
            goto L_0x0042
        L_0x0040:
            r4 = r22
        L_0x0042:
            java.lang.String r3 = com.anggrayudi.storage.file.MimeType.getFullFileName(r3, r4)
            java.lang.String r2 = r2.removeForbiddenCharsFromFilename$storage_release(r3)
            java.lang.String r10 = com.anggrayudi.storage.extension.TextUtils.trimFileSeparator(r2)
            com.anggrayudi.storage.callback.FileCallback$ConflictResolution r11 = handleFileConflict(r8, r7, r10, r9)
            com.anggrayudi.storage.callback.FileCallback$ConflictResolution r2 = com.anggrayudi.storage.callback.FileCallback.ConflictResolution.SKIP
            if (r11 != r2) goto L_0x0057
            return
        L_0x0057:
            boolean r2 = inInternalStorage(r18, r19)
            if (r2 == 0) goto L_0x0094
            java.io.File r2 = toRawFile(r18, r19)
            if (r2 != 0) goto L_0x0064
            goto L_0x0094
        L_0x0064:
            java.lang.String r3 = getAbsolutePath(r7, r8)
            java.io.File r2 = com.anggrayudi.storage.file.FileUtils.moveTo((java.io.File) r2, (android.content.Context) r8, (java.lang.String) r3, (java.lang.String) r10, (com.anggrayudi.storage.callback.FileCallback.ConflictResolution) r11)
            if (r2 != 0) goto L_0x006f
            goto L_0x0094
        L_0x006f:
            kotlinx.coroutines.CoroutineScope r0 = r23.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            r3 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$lambda-133$$inlined$postToUi$1 r4 = new com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$lambda-133$$inlined$postToUi$1
            r4.<init>(r6, r9, r2)
            r2 = r4
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r4 = 2
            r5 = 0
            r18 = r0
            r19 = r1
            r20 = r3
            r21 = r2
            r22 = r4
            r23 = r5
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r18, r19, r20, r21, r22, r23)
            return
        L_0x0094:
            java.lang.String r2 = getStorageId(r7, r8)
            boolean r3 = isExternalStorageManager(r18, r19)
            if (r3 == 0) goto L_0x0108
            java.lang.String r3 = getStorageId(r18, r19)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r2)
            if (r3 == 0) goto L_0x0108
            java.io.File r3 = toRawFile(r18, r19)
            if (r3 != 0) goto L_0x00d2
            kotlinx.coroutines.CoroutineScope r0 = r23.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            r2 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$$inlined$postToUi$4 r3 = new com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$$inlined$postToUi$4
            r3.<init>(r6, r9)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = 2
            r5 = 0
            r18 = r0
            r19 = r1
            r20 = r2
            r21 = r3
            r22 = r4
            r23 = r5
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r18, r19, r20, r21, r22, r23)
            return
        L_0x00d2:
            java.io.File r4 = toRawFile(r7, r8)
            if (r4 != 0) goto L_0x00d9
            goto L_0x0108
        L_0x00d9:
            java.io.File r3 = com.anggrayudi.storage.file.FileUtils.moveTo((java.io.File) r3, (android.content.Context) r8, (java.io.File) r4, (java.lang.String) r10, (com.anggrayudi.storage.callback.FileCallback.ConflictResolution) r11)
            if (r3 != 0) goto L_0x00e3
            r3 = r6
            java.lang.Void r3 = (java.lang.Void) r3
            goto L_0x0108
        L_0x00e3:
            kotlinx.coroutines.CoroutineScope r0 = r23.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            r2 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$lambda-137$lambda-136$$inlined$postToUi$1 r4 = new com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$lambda-137$lambda-136$$inlined$postToUi$1
            r4.<init>(r6, r9, r3)
            r3 = r4
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = 2
            r5 = 0
            r18 = r0
            r19 = r1
            r20 = r2
            r21 = r3
            r22 = r4
            r23 = r5
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r18, r19, r20, r21, r22, r23)
            return
        L_0x0108:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x023c }
            r4 = 24
            if (r3 < r4) goto L_0x0189
            boolean r3 = isRawFile(r18)     // Catch:{ all -> 0x023c }
            if (r3 != 0) goto L_0x0189
            boolean r3 = isTreeDocumentFile(r7)     // Catch:{ all -> 0x023c }
            if (r3 == 0) goto L_0x0189
            java.lang.String r3 = getStorageId(r18, r19)     // Catch:{ all -> 0x023c }
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r2)     // Catch:{ all -> 0x023c }
            if (r3 == 0) goto L_0x0189
            androidx.documentfile.provider.DocumentFile r3 = r18.getParentFile()     // Catch:{ all -> 0x023c }
            if (r3 != 0) goto L_0x012c
        L_0x012a:
            r3 = r6
            goto L_0x0143
        L_0x012c:
            android.net.Uri r3 = r3.getUri()     // Catch:{ all -> 0x023c }
            if (r3 != 0) goto L_0x0133
            goto L_0x012a
        L_0x0133:
            android.content.ContentResolver r4 = r19.getContentResolver()     // Catch:{ all -> 0x023c }
            android.net.Uri r5 = r18.getUri()     // Catch:{ all -> 0x023c }
            android.net.Uri r12 = r7.getUri()     // Catch:{ all -> 0x023c }
            android.net.Uri r3 = android.provider.DocumentsContract.moveDocument(r4, r5, r3, r12)     // Catch:{ all -> 0x023c }
        L_0x0143:
            if (r3 == 0) goto L_0x0189
            androidx.documentfile.provider.DocumentFile r0 = com.anggrayudi.storage.extension.ContextUtils.fromTreeUri(r8, r3)     // Catch:{ all -> 0x023c }
            if (r0 == 0) goto L_0x0171
            boolean r2 = r0.isFile()     // Catch:{ all -> 0x023c }
            if (r2 == 0) goto L_0x0171
            if (r1 == 0) goto L_0x0156
            r0.renameTo(r10)     // Catch:{ all -> 0x023c }
        L_0x0156:
            kotlinx.coroutines.CoroutineScope r11 = r23.getUiScope()     // Catch:{ all -> 0x023c }
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()     // Catch:{ all -> 0x023c }
            r12 = r1
            kotlin.coroutines.CoroutineContext r12 = (kotlin.coroutines.CoroutineContext) r12     // Catch:{ all -> 0x023c }
            r13 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$$inlined$postToUi$5 r1 = new com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$$inlined$postToUi$5     // Catch:{ all -> 0x023c }
            r1.<init>(r6, r9, r0)     // Catch:{ all -> 0x023c }
            r14 = r1
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14     // Catch:{ all -> 0x023c }
            r15 = 2
            r16 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x023c }
            goto L_0x0188
        L_0x0171:
            kotlinx.coroutines.CoroutineScope r0 = r23.getUiScope()     // Catch:{ all -> 0x023c }
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()     // Catch:{ all -> 0x023c }
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1     // Catch:{ all -> 0x023c }
            r2 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$$inlined$postToUi$6 r3 = new com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$$inlined$postToUi$6     // Catch:{ all -> 0x023c }
            r3.<init>(r6, r9)     // Catch:{ all -> 0x023c }
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3     // Catch:{ all -> 0x023c }
            r4 = 2
            r5 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r0, r1, r2, r3, r4, r5)     // Catch:{ all -> 0x023c }
        L_0x0188:
            return
        L_0x0189:
            long r1 = com.anggrayudi.storage.file.DocumentFileCompat.getFreeSpace(r8, r2)     // Catch:{ all -> 0x023c }
            long r3 = r18.length()     // Catch:{ all -> 0x023c }
            boolean r1 = r9.onCheckFreeSpace(r1, r3)     // Catch:{ all -> 0x023c }
            if (r1 != 0) goto L_0x01b3
            kotlinx.coroutines.CoroutineScope r12 = r23.getUiScope()     // Catch:{ all -> 0x023c }
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getMain()     // Catch:{ all -> 0x023c }
            r13 = r0
            kotlin.coroutines.CoroutineContext r13 = (kotlin.coroutines.CoroutineContext) r13     // Catch:{ all -> 0x023c }
            r14 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$$inlined$postToUi$7 r0 = new com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$$inlined$postToUi$7     // Catch:{ all -> 0x023c }
            r0.<init>(r6, r9)     // Catch:{ all -> 0x023c }
            r15 = r0
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15     // Catch:{ all -> 0x023c }
            r16 = 2
            r17 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x023c }
            return
        L_0x01b3:
            java.lang.Thread r12 = java.lang.Thread.currentThread()
            kotlinx.coroutines.CoroutineScope r2 = r23.getUiScope()
            com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$$inlined$awaitUiResult$1 r13 = new com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$$inlined$awaitUiResult$1
            r3 = 0
            r1 = r13
            r4 = r23
            r5 = r18
            r14 = r6
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r1 = 1
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(r14, r13, r1, r14)
            java.lang.Number r2 = (java.lang.Number) r2
            long r12 = r2.longValue()
            r2 = 0
            int r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x01dc
            return
        L_0x01dc:
            if (r4 <= 0) goto L_0x01e0
            r15 = 1
            goto L_0x01e2
        L_0x01e0:
            r1 = 0
            r15 = 0
        L_0x01e2:
            if (r22 != 0) goto L_0x01ea
            java.lang.String r1 = getMimeTypeByFileName(r18)     // Catch:{ Exception -> 0x0216 }
            r4 = r1
            goto L_0x01ec
        L_0x01ea:
            r4 = r22
        L_0x01ec:
            com.anggrayudi.storage.file.CreateMode r5 = r11.toCreateMode()     // Catch:{ Exception -> 0x0216 }
            r1 = r19
            r2 = r7
            r3 = r10
            r6 = r23
            androidx.documentfile.provider.DocumentFile r10 = createTargetFile(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0216 }
            if (r10 != 0) goto L_0x01fd
            return
        L_0x01fd:
            r11 = r9
            com.anggrayudi.storage.callback.BaseFileCallback r11 = (com.anggrayudi.storage.callback.BaseFileCallback) r11     // Catch:{ Exception -> 0x0216 }
            com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$11 r16 = new com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$11     // Catch:{ Exception -> 0x0216 }
            r1 = r16
            r2 = r18
            r3 = r10
            r4 = r15
            r5 = r12
            r7 = r23
            r1.<init>(r2, r3, r4, r5, r7)     // Catch:{ Exception -> 0x0216 }
            r1 = r16
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1     // Catch:{ Exception -> 0x0216 }
            createFileStreams((android.content.Context) r8, (androidx.documentfile.provider.DocumentFile) r0, (androidx.documentfile.provider.DocumentFile) r10, r11, (kotlin.jvm.functions.Function2<? super java.io.InputStream, ? super java.io.OutputStream, kotlin.Unit>) r1)     // Catch:{ Exception -> 0x0216 }
            goto L_0x023b
        L_0x0216:
            r0 = move-exception
            kotlinx.coroutines.CoroutineScope r1 = r23.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            r3 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$$inlined$postToUi$9 r4 = new com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$$inlined$postToUi$9
            r4.<init>(r14, r9, r0)
            r0 = r4
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r4 = 2
            r5 = 0
            r18 = r1
            r19 = r2
            r20 = r3
            r21 = r0
            r22 = r4
            r23 = r5
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r18, r19, r20, r21, r22, r23)
        L_0x023b:
            return
        L_0x023c:
            r14 = r6
            kotlinx.coroutines.CoroutineScope r0 = r23.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            r2 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$$inlined$postToUi$8 r3 = new com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$$inlined$postToUi$8
            r3.<init>(r14, r9)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = 2
            r5 = 0
            r18 = r0
            r19 = r1
            r20 = r2
            r21 = r3
            r22 = r4
            r23 = r5
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r18, r19, r20, r21, r22, r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileUtils.moveFileTo(androidx.documentfile.provider.DocumentFile, android.content.Context, androidx.documentfile.provider.DocumentFile, java.lang.String, java.lang.String, com.anggrayudi.storage.callback.FileCallback):void");
    }

    private static final boolean simpleCheckSourceFile(DocumentFile documentFile, FileCallback fileCallback) {
        if (!documentFile.isFile()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$simpleCheckSourceFile$$inlined$postToUi$1((Continuation) null, fileCallback), 2, (Object) null);
            return true;
        } else if (documentFile.canRead()) {
            return false;
        } else {
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$simpleCheckSourceFile$$inlined$postToUi$2((Continuation) null, fileCallback), 2, (Object) null);
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        if (r1 != false) goto L_0x008b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void copyFileToMedia(androidx.documentfile.provider.DocumentFile r15, android.content.Context r16, com.anggrayudi.storage.media.FileDescription r17, com.anggrayudi.storage.callback.FileCallback r18, com.anggrayudi.storage.file.PublicDirectory r19, boolean r20, com.anggrayudi.storage.file.CreateMode r21) {
        /*
            r0 = r15
            r8 = r16
            r9 = r17
            r10 = r18
            r11 = r20
            r12 = r21
            boolean r1 = simpleCheckSourceFile(r15, r10)
            if (r1 == 0) goto L_0x0012
            return
        L_0x0012:
            java.lang.String r3 = r17.getSubFolder()
            r4 = 1
            r5 = 0
            r6 = 16
            r7 = 0
            r1 = r16
            r2 = r19
            androidx.documentfile.provider.DocumentFile r7 = com.anggrayudi.storage.file.DocumentFileCompat.fromPublicFolder$default(r1, r2, r3, r4, r5, r6, r7)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            r13 = 0
            r14 = 0
            if (r1 < r2) goto L_0x008b
            if (r11 == 0) goto L_0x0041
            boolean r1 = isRawFile(r15)
            if (r1 != 0) goto L_0x0041
            r1 = 1
            if (r7 != 0) goto L_0x0038
        L_0x0036:
            r1 = 0
            goto L_0x003e
        L_0x0038:
            boolean r2 = isTreeDocumentFile(r7)
            if (r2 != r1) goto L_0x0036
        L_0x003e:
            if (r1 == 0) goto L_0x0041
            goto L_0x008b
        L_0x0041:
            com.anggrayudi.storage.file.CreateMode r1 = com.anggrayudi.storage.file.CreateMode.REUSE
            if (r12 != r1) goto L_0x0049
            com.anggrayudi.storage.file.CreateMode r1 = com.anggrayudi.storage.file.CreateMode.CREATE_NEW
            r4 = r1
            goto L_0x004a
        L_0x0049:
            r4 = r12
        L_0x004a:
            com.anggrayudi.storage.file.PublicDirectory r1 = com.anggrayudi.storage.file.PublicDirectory.DOWNLOADS
            r2 = r19
            if (r2 != r1) goto L_0x0055
            com.anggrayudi.storage.media.MediaFile r1 = com.anggrayudi.storage.media.MediaStoreCompat.createDownload(r8, r9, r4)
            goto L_0x0060
        L_0x0055:
            r3 = 0
            r5 = 4
            r6 = 0
            r1 = r16
            r2 = r17
            com.anggrayudi.storage.media.MediaFile r1 = com.anggrayudi.storage.media.MediaStoreCompat.createImage$default(r1, r2, r3, r4, r5, r6)
        L_0x0060:
            if (r1 != 0) goto L_0x0086
            kotlinx.coroutines.CoroutineScope r0 = r18.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            r2 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyFileToMedia$$inlined$postToUi$2 r3 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFileToMedia$$inlined$postToUi$2
            r3.<init>(r14, r10)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = 2
            r5 = 0
            r15 = r0
            r16 = r1
            r17 = r2
            r18 = r3
            r19 = r4
            r20 = r5
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r15, r16, r17, r18, r19, r20)
            goto L_0x010b
        L_0x0086:
            copyFileTo((androidx.documentfile.provider.DocumentFile) r15, (android.content.Context) r8, (com.anggrayudi.storage.media.MediaFile) r1, (boolean) r11, (com.anggrayudi.storage.callback.FileCallback) r10)
            goto L_0x010b
        L_0x008b:
            if (r7 != 0) goto L_0x00b0
            kotlinx.coroutines.CoroutineScope r0 = r18.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            r2 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyFileToMedia$$inlined$postToUi$1 r3 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFileToMedia$$inlined$postToUi$1
            r3.<init>(r14, r10)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = 2
            r5 = 0
            r15 = r0
            r16 = r1
            r17 = r2
            r18 = r3
            r19 = r4
            r20 = r5
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r15, r16, r17, r18, r19, r20)
            return
        L_0x00b0:
            java.lang.String r3 = r17.getFullName()
            r4 = 0
            r5 = 4
            r6 = 0
            r1 = r7
            r2 = r16
            androidx.documentfile.provider.DocumentFile r1 = child$default(r1, r2, r3, r4, r5, r6)
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x00c3
            goto L_0x00ff
        L_0x00c3:
            com.anggrayudi.storage.file.CreateMode r3 = com.anggrayudi.storage.file.CreateMode.REPLACE
            if (r12 != r3) goto L_0x00f1
            r3 = 2
            boolean r1 = forceDelete$default(r1, r8, r13, r3, r14)
            if (r1 != 0) goto L_0x00ff
            kotlinx.coroutines.CoroutineScope r0 = r18.getUiScope()
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            r2 = 0
            com.anggrayudi.storage.file.DocumentFileUtils$copyFileToMedia$lambda-149$$inlined$postToUi$1 r3 = new com.anggrayudi.storage.file.DocumentFileUtils$copyFileToMedia$lambda-149$$inlined$postToUi$1
            r3.<init>(r14, r10)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = 2
            r5 = 0
            r15 = r0
            r16 = r1
            r17 = r2
            r18 = r3
            r19 = r4
            r20 = r5
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r15, r16, r17, r18, r19, r20)
            return
        L_0x00f1:
            java.lang.String r1 = r1.getName()
            if (r1 != 0) goto L_0x00f8
            r1 = r2
        L_0x00f8:
            java.lang.String r1 = autoIncrementFileName(r7, r8, r1)
            r9.setName(r1)
        L_0x00ff:
            r9.setSubFolder(r2)
            if (r11 == 0) goto L_0x0108
            moveFileTo((androidx.documentfile.provider.DocumentFile) r15, (android.content.Context) r8, (androidx.documentfile.provider.DocumentFile) r7, (com.anggrayudi.storage.media.FileDescription) r9, (com.anggrayudi.storage.callback.FileCallback) r10)
            goto L_0x010b
        L_0x0108:
            copyFileTo((androidx.documentfile.provider.DocumentFile) r15, (android.content.Context) r8, (androidx.documentfile.provider.DocumentFile) r7, (com.anggrayudi.storage.media.FileDescription) r9, (com.anggrayudi.storage.callback.FileCallback) r10)
        L_0x010b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileUtils.copyFileToMedia(androidx.documentfile.provider.DocumentFile, android.content.Context, com.anggrayudi.storage.media.FileDescription, com.anggrayudi.storage.callback.FileCallback, com.anggrayudi.storage.file.PublicDirectory, boolean, com.anggrayudi.storage.file.CreateMode):void");
    }

    public static /* synthetic */ void copyFileToDownloadMedia$default(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback fileCallback, CreateMode createMode, int i, Object obj) {
        if ((i & 8) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        copyFileToDownloadMedia(documentFile, context, fileDescription, fileCallback, createMode);
    }

    public static final void copyFileToDownloadMedia(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback fileCallback, CreateMode createMode) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "fileDescription");
        Intrinsics.checkNotNullParameter(fileCallback, "callback");
        Intrinsics.checkNotNullParameter(createMode, "mode");
        copyFileToMedia(documentFile, context, fileDescription, fileCallback, PublicDirectory.DOWNLOADS, false, createMode);
    }

    public static /* synthetic */ void copyFileToPictureMedia$default(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback fileCallback, CreateMode createMode, int i, Object obj) {
        if ((i & 8) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        copyFileToPictureMedia(documentFile, context, fileDescription, fileCallback, createMode);
    }

    public static final void copyFileToPictureMedia(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback fileCallback, CreateMode createMode) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "fileDescription");
        Intrinsics.checkNotNullParameter(fileCallback, "callback");
        Intrinsics.checkNotNullParameter(createMode, "mode");
        copyFileToMedia(documentFile, context, fileDescription, fileCallback, PublicDirectory.PICTURES, false, createMode);
    }

    public static /* synthetic */ void moveFileToDownloadMedia$default(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback fileCallback, CreateMode createMode, int i, Object obj) {
        if ((i & 8) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        moveFileToDownloadMedia(documentFile, context, fileDescription, fileCallback, createMode);
    }

    public static final void moveFileToDownloadMedia(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback fileCallback, CreateMode createMode) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "fileDescription");
        Intrinsics.checkNotNullParameter(fileCallback, "callback");
        Intrinsics.checkNotNullParameter(createMode, "mode");
        copyFileToMedia(documentFile, context, fileDescription, fileCallback, PublicDirectory.DOWNLOADS, true, createMode);
    }

    public static /* synthetic */ void moveFileToPictureMedia$default(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback fileCallback, CreateMode createMode, int i, Object obj) {
        if ((i & 8) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        moveFileToPictureMedia(documentFile, context, fileDescription, fileCallback, createMode);
    }

    public static final void moveFileToPictureMedia(DocumentFile documentFile, Context context, FileDescription fileDescription, FileCallback fileCallback, CreateMode createMode) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "fileDescription");
        Intrinsics.checkNotNullParameter(fileCallback, "callback");
        Intrinsics.checkNotNullParameter(createMode, "mode");
        copyFileToMedia(documentFile, context, fileDescription, fileCallback, PublicDirectory.PICTURES, true, createMode);
    }

    public static final void moveFileTo(DocumentFile documentFile, Context context, MediaFile mediaFile, FileCallback fileCallback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaFile, "targetFile");
        Intrinsics.checkNotNullParameter(fileCallback, "callback");
        copyFileTo(documentFile, context, mediaFile, true, fileCallback);
    }

    public static final void copyFileTo(DocumentFile documentFile, Context context, MediaFile mediaFile, FileCallback fileCallback) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaFile, "targetFile");
        Intrinsics.checkNotNullParameter(fileCallback, "callback");
        copyFileTo(documentFile, context, mediaFile, false, fileCallback);
    }

    private static final void copyFileTo(DocumentFile documentFile, Context context, MediaFile mediaFile, boolean z, FileCallback fileCallback) {
        CoroutineScope uiScope;
        CoroutineContext main;
        CoroutineStart coroutineStart;
        Function2 documentFileUtils$createFileStreams$$inlined$postToUi$4;
        FileCallback fileCallback2 = fileCallback;
        if (!simpleCheckSourceFile(documentFile, fileCallback2)) {
            try {
                if (!fileCallback2.onCheckFreeSpace(DocumentFileCompat.getFreeSpace(context, StorageId.PRIMARY), documentFile.length())) {
                    Job unused = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$copyFileTo$$inlined$postToUi$7((Continuation) null, fileCallback2), 2, (Object) null);
                    return;
                }
                long longValue = ((Number) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new DocumentFileUtils$copyFileTo$$inlined$awaitUiResult$2(fileCallback.getUiScope(), (Continuation) null, fileCallback, documentFile, Thread.currentThread()), 1, (Object) null)).longValue();
                int i = (longValue > 0 ? 1 : (longValue == 0 ? 0 : -1));
                if (i >= 0) {
                    boolean z2 = i > 0;
                    try {
                        OutputStream openOutputStream$default = MediaFile.openOutputStream$default(mediaFile, false, 1, (Object) null);
                        if (openOutputStream$default == null) {
                            uiScope = fileCallback.getUiScope();
                            main = Dispatchers.getMain();
                            coroutineStart = null;
                            documentFileUtils$createFileStreams$$inlined$postToUi$4 = new DocumentFileUtils$createFileStreams$$inlined$postToUi$3((Continuation) null, fileCallback2);
                        } else {
                            InputStream openInputStream = openInputStream(documentFile, context);
                            if (openInputStream == null) {
                                IOUtils.closeStream(openOutputStream$default);
                                uiScope = fileCallback.getUiScope();
                                main = Dispatchers.getMain();
                                coroutineStart = null;
                                documentFileUtils$createFileStreams$$inlined$postToUi$4 = new DocumentFileUtils$createFileStreams$$inlined$postToUi$4((Continuation) null, fileCallback2);
                            } else {
                                copyFileStream(documentFile, openInputStream, openOutputStream$default, mediaFile, z2, longValue, z, fileCallback);
                                return;
                            }
                        }
                        Job unused2 = BuildersKt__Builders_commonKt.launch$default(uiScope, main, coroutineStart, documentFileUtils$createFileStreams$$inlined$postToUi$4, 2, (Object) null);
                    } catch (Exception e) {
                        Job unused3 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$copyFileTo$$inlined$postToUi$9((Continuation) null, fileCallback2, e), 2, (Object) null);
                    }
                }
            } catch (Throwable unused4) {
                Job unused5 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$copyFileTo$$inlined$postToUi$8((Continuation) null, fileCallback2), 2, (Object) null);
            }
        }
    }

    public static final FileCallback.ErrorCode toFileCallbackErrorCode(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "<this>");
        if (exc instanceof SecurityException) {
            return FileCallback.ErrorCode.STORAGE_PERMISSION_DENIED;
        }
        if (exc instanceof InterruptedIOException ? true : exc instanceof InterruptedException) {
            return FileCallback.ErrorCode.CANCELED;
        }
        return FileCallback.ErrorCode.UNKNOWN_IO_ERROR;
    }

    private static final FileCallback.ConflictResolution handleFileConflict(Context context, DocumentFile documentFile, String str, FileCallback fileCallback) {
        DocumentFile child$default = child$default(documentFile, context, str, false, 4, (Object) null);
        if (child$default == null) {
            return FileCallback.ConflictResolution.CREATE_NEW;
        }
        FileCallback.ConflictResolution conflictResolution = (FileCallback.ConflictResolution) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new DocumentFileUtils$handleFileConflict$lambda159$$inlined$awaitUiResultWithPending$1(fileCallback.getUiScope(), (Continuation) null, fileCallback, child$default), 1, (Object) null);
        if (conflictResolution == FileCallback.ConflictResolution.REPLACE) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$handleFileConflict$lambda159$$inlined$postToUi$1((Continuation) null, fileCallback), 2, (Object) null);
            if (!forceDelete$default(child$default, context, false, 2, (Object) null)) {
                Job unused2 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$handleFileConflict$lambda159$$inlined$postToUi$2((Continuation) null, fileCallback), 2, (Object) null);
                return FileCallback.ConflictResolution.SKIP;
            }
        }
        return conflictResolution;
    }

    private static final FolderCallback.ConflictResolution handleParentFolderConflict(Context context, DocumentFile documentFile, String str, FolderCallback folderCallback) {
        DocumentFile child$default = child$default(documentFile, context, str, false, 4, (Object) null);
        if (child$default == null) {
            return FolderCallback.ConflictResolution.CREATE_NEW;
        }
        boolean isDirectory = child$default.isDirectory();
        if (isDirectory && isEmpty(child$default, context)) {
            return FolderCallback.ConflictResolution.MERGE;
        }
        FolderCallback.ConflictResolution conflictResolution = (FolderCallback.ConflictResolution) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new DocumentFileUtils$handleParentFolderConflict$lambda166$$inlined$awaitUiResultWithPending$1(folderCallback.getUiScope(), (Continuation) null, folderCallback, child$default, isDirectory), 1, (Object) null);
        int i = WhenMappings.$EnumSwitchMapping$2[conflictResolution.ordinal()];
        if (i == 1) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$handleParentFolderConflict$lambda166$$inlined$postToUi$1((Continuation) null, folderCallback), 2, (Object) null);
            boolean isDirectory2 = child$default.isDirectory();
            if (!forceDelete(child$default, context, true)) {
                Job unused2 = BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$handleParentFolderConflict$lambda166$$inlined$postToUi$3((Continuation) null, folderCallback), 2, (Object) null);
                return FolderCallback.ConflictResolution.SKIP;
            } else if (!isDirectory2) {
                DocumentFile parentFile = child$default.getParentFile();
                if ((parentFile == null ? null : parentFile.createDirectory(str)) == null) {
                    Job unused3 = BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$handleParentFolderConflict$lambda166$$inlined$postToUi$2((Continuation) null, folderCallback), 2, (Object) null);
                    return FolderCallback.ConflictResolution.SKIP;
                }
            }
        } else if (i == 2 && child$default.isFile()) {
            if (child$default.delete()) {
                DocumentFile parentFile2 = child$default.getParentFile();
                if ((parentFile2 == null ? null : parentFile2.createDirectory(str)) == null) {
                    Job unused4 = BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$handleParentFolderConflict$lambda166$$inlined$postToUi$4((Continuation) null, folderCallback), 2, (Object) null);
                    return FolderCallback.ConflictResolution.SKIP;
                }
            } else {
                Job unused5 = BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$handleParentFolderConflict$lambda166$$inlined$postToUi$5((Continuation) null, folderCallback), 2, (Object) null);
                return FolderCallback.ConflictResolution.SKIP;
            }
        }
        return conflictResolution;
    }

    private static final List<MultipleFileCallback.ParentConflict> handleParentFolderConflict(List<? extends DocumentFile> list, Context context, DocumentFile documentFile, MultipleFileCallback multipleFileCallback) {
        boolean z;
        boolean z2;
        FolderCallback.ConflictResolution conflictResolution;
        Context context2 = context;
        MultipleFileCallback multipleFileCallback2 = multipleFileCallback;
        Iterable<DocumentFile> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (DocumentFile name : iterable) {
            arrayList.add(name.getName());
        }
        List list2 = (List) arrayList;
        DocumentFile[] listFiles = documentFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "targetParentFolder.listFiles()");
        Object[] objArr = (Object[]) listFiles;
        Collection arrayList2 = new ArrayList();
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            if (list2.contains(((DocumentFile) obj).getName())) {
                arrayList2.add(obj);
            }
        }
        Iterable iterable2 = (List) arrayList2;
        Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        Iterator it = iterable2.iterator();
        while (true) {
            boolean z3 = true;
            if (it.hasNext()) {
                DocumentFile documentFile2 = (DocumentFile) it.next();
                for (DocumentFile documentFile3 : iterable) {
                    if (Intrinsics.areEqual((Object) documentFile3.getName(), (Object) documentFile2.getName())) {
                        if (!documentFile3.isDirectory() || !documentFile2.isDirectory()) {
                            z3 = false;
                        }
                        if (z3) {
                            Intrinsics.checkNotNullExpressionValue(documentFile2, "it");
                            if (isEmpty(documentFile2, context2)) {
                                conflictResolution = FolderCallback.ConflictResolution.MERGE;
                                Intrinsics.checkNotNullExpressionValue(documentFile2, "it");
                                arrayList3.add(new MultipleFileCallback.ParentConflict(documentFile3, documentFile2, z3, conflictResolution));
                            }
                        }
                        conflictResolution = FolderCallback.ConflictResolution.CREATE_NEW;
                        Intrinsics.checkNotNullExpressionValue(documentFile2, "it");
                        arrayList3.add(new MultipleFileCallback.ParentConflict(documentFile3, documentFile2, z3, conflictResolution));
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            Iterable iterable3 = (List) arrayList3;
            Collection arrayList4 = new ArrayList();
            for (Object next : iterable3) {
                if (((MultipleFileCallback.ParentConflict) next).getSolution() != FolderCallback.ConflictResolution.MERGE) {
                    arrayList4.add(next);
                }
            }
            List mutableList = CollectionsKt.toMutableList((List) arrayList4);
            if (!(!mutableList.isEmpty())) {
                return CollectionsKt.emptyList();
            }
            Iterable iterable4 = mutableList;
            Collection arrayList5 = new ArrayList();
            for (Object next2 : iterable4) {
                if (((MultipleFileCallback.ParentConflict) next2).getSource().isFile()) {
                    arrayList5.add(next2);
                }
            }
            List mutableList2 = CollectionsKt.toMutableList((List) arrayList5);
            Collection arrayList6 = new ArrayList();
            for (Object next3 : iterable4) {
                if (((MultipleFileCallback.ParentConflict) next3).getSource().isDirectory()) {
                    arrayList6.add(next3);
                }
            }
            List list3 = (List) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new DocumentFileUtils$handleParentFolderConflict$$inlined$awaitUiResultWithPending$1(multipleFileCallback.getUiScope(), (Continuation) null, multipleFileCallback, documentFile, CollectionsKt.toMutableList((List) arrayList6), mutableList2), 1, (Object) null);
            Iterable<MultipleFileCallback.ParentConflict> iterable5 = list3;
            if (!(iterable5 instanceof Collection) || !((Collection) iterable5).isEmpty()) {
                Iterator it2 = iterable5.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (((MultipleFileCallback.ParentConflict) it2.next()).getSolution() == FolderCallback.ConflictResolution.REPLACE) {
                        z2 = true;
                        continue;
                    } else {
                        z2 = false;
                        continue;
                    }
                    if (z2) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(multipleFileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$handleParentFolderConflict$$inlined$postToUi$1((Continuation) null, multipleFileCallback2), 2, (Object) null);
            }
            for (MultipleFileCallback.ParentConflict parentConflict : iterable5) {
                int i2 = WhenMappings.$EnumSwitchMapping$2[parentConflict.getSolution().ordinal()];
                if (i2 == 1) {
                    DocumentFile target = parentConflict.getTarget();
                    if (!(deleteRecursively(target, context2, true) || !target.exists())) {
                        Job unused2 = BuildersKt__Builders_commonKt.launch$default(multipleFileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$handleParentFolderConflict$lambda180$$inlined$postToUi$1((Continuation) null, multipleFileCallback2), 2, (Object) null);
                        return null;
                    }
                } else if (i2 == 2 && parentConflict.getTarget().isFile() && !parentConflict.getTarget().delete()) {
                    Job unused3 = BuildersKt__Builders_commonKt.launch$default(multipleFileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$handleParentFolderConflict$lambda180$$inlined$postToUi$2((Continuation) null, multipleFileCallback2), 2, (Object) null);
                    return null;
                }
            }
            List<MultipleFileCallback.ParentConflict> mutableList3 = CollectionsKt.toMutableList(list3);
            Collection arrayList7 = new ArrayList();
            for (Object next4 : iterable3) {
                if (((MultipleFileCallback.ParentConflict) next4).getSolution() == FolderCallback.ConflictResolution.MERGE) {
                    arrayList7.add(next4);
                }
            }
            mutableList3.addAll((List) arrayList7);
            return mutableList3;
        }
    }
}
