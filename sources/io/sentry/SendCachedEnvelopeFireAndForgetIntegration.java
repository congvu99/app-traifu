package io.sentry;

import io.sentry.SendCachedEnvelopeFireAndForgetIntegration;
import io.sentry.util.Objects;
import java.io.File;

public final class SendCachedEnvelopeFireAndForgetIntegration implements Integration {
    private final SendFireAndForgetFactory factory;

    public interface SendFireAndForget {
        void send();
    }

    public interface SendFireAndForgetDirPath {
        String getDirPath();
    }

    public interface SendFireAndForgetFactory {
        SendFireAndForget create(IHub iHub, SentryOptions sentryOptions);

        boolean hasValidPath(String str, ILogger iLogger);

        SendFireAndForget processDir(DirectoryProcessor directoryProcessor, String str, ILogger iLogger);

        /* renamed from: io.sentry.SendCachedEnvelopeFireAndForgetIntegration$SendFireAndForgetFactory$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static boolean $default$hasValidPath(SendFireAndForgetFactory _this, String str, ILogger iLogger) {
                if (str != null && !str.isEmpty()) {
                    return true;
                }
                iLogger.log(SentryLevel.INFO, "No cached dir path is defined in options.", new Object[0]);
                return false;
            }

            public static SendFireAndForget $default$processDir(SendFireAndForgetFactory _this, DirectoryProcessor directoryProcessor, String str, ILogger iLogger) {
                return 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: RETURN  
                      (wrap: io.sentry.-$$Lambda$SendCachedEnvelopeFireAndForgetIntegration$SendFireAndForgetFactory$fw_M6vxYehvhSeLyExDmpVukEZU : 0x0007: CONSTRUCTOR  (r1v0 io.sentry.-$$Lambda$SendCachedEnvelopeFireAndForgetIntegration$SendFireAndForgetFactory$fw_M6vxYehvhSeLyExDmpVukEZU) = 
                      (r5v0 'iLogger' io.sentry.ILogger)
                      (r4v0 'str' java.lang.String)
                      (r3v0 'directoryProcessor' io.sentry.DirectoryProcessor)
                      (wrap: java.io.File : 0x0002: CONSTRUCTOR  (r0v0 java.io.File) = (r4v0 'str' java.lang.String) call: java.io.File.<init>(java.lang.String):void type: CONSTRUCTOR)
                     call: io.sentry.-$$Lambda$SendCachedEnvelopeFireAndForgetIntegration$SendFireAndForgetFactory$fw_M6vxYehvhSeLyExDmpVukEZU.<init>(io.sentry.ILogger, java.lang.String, io.sentry.DirectoryProcessor, java.io.File):void type: CONSTRUCTOR)
                     in method: io.sentry.SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetFactory.-CC.$default$processDir(io.sentry.SendCachedEnvelopeFireAndForgetIntegration$SendFireAndForgetFactory, io.sentry.DirectoryProcessor, java.lang.String, io.sentry.ILogger):io.sentry.SendCachedEnvelopeFireAndForgetIntegration$SendFireAndForget, dex: classes4.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0007: CONSTRUCTOR  (r1v0 io.sentry.-$$Lambda$SendCachedEnvelopeFireAndForgetIntegration$SendFireAndForgetFactory$fw_M6vxYehvhSeLyExDmpVukEZU) = 
                      (r5v0 'iLogger' io.sentry.ILogger)
                      (r4v0 'str' java.lang.String)
                      (r3v0 'directoryProcessor' io.sentry.DirectoryProcessor)
                      (wrap: java.io.File : 0x0002: CONSTRUCTOR  (r0v0 java.io.File) = (r4v0 'str' java.lang.String) call: java.io.File.<init>(java.lang.String):void type: CONSTRUCTOR)
                     call: io.sentry.-$$Lambda$SendCachedEnvelopeFireAndForgetIntegration$SendFireAndForgetFactory$fw_M6vxYehvhSeLyExDmpVukEZU.<init>(io.sentry.ILogger, java.lang.String, io.sentry.DirectoryProcessor, java.io.File):void type: CONSTRUCTOR in method: io.sentry.SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetFactory.-CC.$default$processDir(io.sentry.SendCachedEnvelopeFireAndForgetIntegration$SendFireAndForgetFactory, io.sentry.DirectoryProcessor, java.lang.String, io.sentry.ILogger):io.sentry.SendCachedEnvelopeFireAndForgetIntegration$SendFireAndForget, dex: classes4.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:314)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	... 59 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: io.sentry.-$$Lambda$SendCachedEnvelopeFireAndForgetIntegration$SendFireAndForgetFactory$fw_M6vxYehvhSeLyExDmpVukEZU, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	... 63 more
                    */
                /*
                    java.io.File r0 = new java.io.File
                    r0.<init>(r4)
                    io.sentry.-$$Lambda$SendCachedEnvelopeFireAndForgetIntegration$SendFireAndForgetFactory$fw_M6vxYehvhSeLyExDmpVukEZU r1 = new io.sentry.-$$Lambda$SendCachedEnvelopeFireAndForgetIntegration$SendFireAndForgetFactory$fw_M6vxYehvhSeLyExDmpVukEZU
                    r1.<init>(r5, r4, r3, r0)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: io.sentry.SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetFactory.CC.$default$processDir(io.sentry.SendCachedEnvelopeFireAndForgetIntegration$SendFireAndForgetFactory, io.sentry.DirectoryProcessor, java.lang.String, io.sentry.ILogger):io.sentry.SendCachedEnvelopeFireAndForgetIntegration$SendFireAndForget");
            }

            public static /* synthetic */ void lambda$processDir$0(ILogger iLogger, String str, DirectoryProcessor directoryProcessor, File file) {
                iLogger.log(SentryLevel.DEBUG, "Started processing cached files from %s", str);
                directoryProcessor.processDirectory(file);
                iLogger.log(SentryLevel.DEBUG, "Finished processing cached files from %s", str);
            }
        }
    }

    public SendCachedEnvelopeFireAndForgetIntegration(SendFireAndForgetFactory sendFireAndForgetFactory) {
        this.factory = (SendFireAndForgetFactory) Objects.requireNonNull(sendFireAndForgetFactory, "SendFireAndForgetFactory is required");
    }

    public final void register(IHub iHub, SentryOptions sentryOptions) {
        Objects.requireNonNull(iHub, "Hub is required");
        Objects.requireNonNull(sentryOptions, "SentryOptions is required");
        if (!this.factory.hasValidPath(sentryOptions.getCacheDirPath(), sentryOptions.getLogger())) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "No cache dir path is defined in options.", new Object[0]);
            return;
        }
        SendFireAndForget create = this.factory.create(iHub, sentryOptions);
        if (create == null) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "SendFireAndForget factory is null.", new Object[0]);
            return;
        }
        try {
            sentryOptions.getExecutorService().submit(new Runnable(sentryOptions) {
                public final /* synthetic */ SentryOptions f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    SendCachedEnvelopeFireAndForgetIntegration.lambda$register$0(SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForget.this, this.f$1);
                }
            });
            sentryOptions.getLogger().log(SentryLevel.DEBUG, "SendCachedEventFireAndForgetIntegration installed.", new Object[0]);
        } catch (Exception e) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "Failed to call the executor. Cached events will not be sent", (Throwable) e);
        }
    }

    static /* synthetic */ void lambda$register$0(SendFireAndForget sendFireAndForget, SentryOptions sentryOptions) {
        try {
            sendFireAndForget.send();
        } catch (Exception e) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "Failed trying to send cached events.", (Throwable) e);
        }
    }
}
