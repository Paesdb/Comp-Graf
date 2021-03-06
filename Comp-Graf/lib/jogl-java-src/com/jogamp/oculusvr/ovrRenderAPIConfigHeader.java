/* !---- DO NOT EDIT: This file autogenerated by com/jogamp/gluegen/JavaEmitter.java on Sat Oct 10 03:31:12 CEST 2015 ----! */


package com.jogamp.oculusvr;

import java.nio.*;

import com.jogamp.gluegen.runtime.*;
import com.jogamp.common.os.*;
import com.jogamp.common.nio.*;
import jogamp.common.os.MachineDataInfoRuntime;

import com.jogamp.oculusvr.*;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class ovrRenderAPIConfigHeader {

  StructAccessor accessor;

  private static final int mdIdx = MachineDataInfoRuntime.getStatic().ordinal();
  private final MachineDataInfo md;

  private static final int[] ovrRenderAPIConfigHeader_size = new int[] { 16 /* ARM_MIPS_32 */, 16 /* X86_32_UNIX */, 16 /* X86_32_MACOS */, 16 /* PPC_32_UNIX */, 16 /* SPARC_32_SUNOS */, 16 /* X86_32_WINDOWS */, 16 /* LP64_UNIX */, 16 /* X86_64_WINDOWS */  };
  private static final int[] API_offset = new int[] { 0 /* ARM_MIPS_32 */, 0 /* X86_32_UNIX */, 0 /* X86_32_MACOS */, 0 /* PPC_32_UNIX */, 0 /* SPARC_32_SUNOS */, 0 /* X86_32_WINDOWS */, 0 /* LP64_UNIX */, 0 /* X86_64_WINDOWS */ };
//private static final int[] API_size = new int[] { 4 /* ARM_MIPS_32 */, 4 /* X86_32_UNIX */, 4 /* X86_32_MACOS */, 4 /* PPC_32_UNIX */, 4 /* SPARC_32_SUNOS */, 4 /* X86_32_WINDOWS */, 4 /* LP64_UNIX */, 4 /* X86_64_WINDOWS */  };
  private static final int[] BackBufferSize_offset = new int[] { 4 /* ARM_MIPS_32 */, 4 /* X86_32_UNIX */, 4 /* X86_32_MACOS */, 4 /* PPC_32_UNIX */, 4 /* SPARC_32_SUNOS */, 4 /* X86_32_WINDOWS */, 4 /* LP64_UNIX */, 4 /* X86_64_WINDOWS */ };
  private static final int[] BackBufferSize_size = new int[] { 8 /* ARM_MIPS_32 */, 8 /* X86_32_UNIX */, 8 /* X86_32_MACOS */, 8 /* PPC_32_UNIX */, 8 /* SPARC_32_SUNOS */, 8 /* X86_32_WINDOWS */, 8 /* LP64_UNIX */, 8 /* X86_64_WINDOWS */  };
  private static final int[] Multisample_offset = new int[] { 12 /* ARM_MIPS_32 */, 12 /* X86_32_UNIX */, 12 /* X86_32_MACOS */, 12 /* PPC_32_UNIX */, 12 /* SPARC_32_SUNOS */, 12 /* X86_32_WINDOWS */, 12 /* LP64_UNIX */, 12 /* X86_64_WINDOWS */ };
//private static final int[] Multisample_size = new int[] { 4 /* ARM_MIPS_32 */, 4 /* X86_32_UNIX */, 4 /* X86_32_MACOS */, 4 /* PPC_32_UNIX */, 4 /* SPARC_32_SUNOS */, 4 /* X86_32_WINDOWS */, 4 /* LP64_UNIX */, 4 /* X86_64_WINDOWS */  };

  public static int size() {
    return ovrRenderAPIConfigHeader_size[mdIdx];
  }

  public static ovrRenderAPIConfigHeader create() {
    return create(Buffers.newDirectByteBuffer(size()));
  }

  public static ovrRenderAPIConfigHeader create(java.nio.ByteBuffer buf) {
      return new ovrRenderAPIConfigHeader(buf);
  }

  ovrRenderAPIConfigHeader(java.nio.ByteBuffer buf) {
    md = MachineDataInfo.StaticConfig.values()[mdIdx].md;
    accessor = new StructAccessor(buf);
  }

  public java.nio.ByteBuffer getBuffer() {
    return accessor.getBuffer();
  }

  /** Setter for native field <code>API</code>: CType[(EnumType) typedef 'ovrRenderAPIType', size [fixed true, lnx64 4], [const[type , false], enum  [const ovrRenderAPIType_] {3: [ovrRenderAPI_None = [0x0L, [long: 0]], [ovrRenderAPI_Count = [0x1L, [long: 1]], [ovrRenderAPI_EnumSize = [0x7fffffff, [int: 2147483647]], }, int]] */
  public ovrRenderAPIConfigHeader setAPI(int val) {
    accessor.setIntAt(API_offset[mdIdx], val);
    return this;
  }

  /** Getter for native field <code>API</code>: CType[(EnumType) typedef 'ovrRenderAPIType', size [fixed true, lnx64 4], [const[type , false], enum  [const ovrRenderAPIType_] {3: [ovrRenderAPI_None = [0x0L, [long: 0]], [ovrRenderAPI_Count = [0x1L, [long: 1]], [ovrRenderAPI_EnumSize = [0x7fffffff, [int: 2147483647]], }, int]] */
  public int getAPI() {
    return accessor.getIntAt(API_offset[mdIdx]);
  }

  /** Getter for native field <code>BackBufferSize</code>: CType[(StructType) typedef 'ovrSizei', size [fixed false, lnx64 8], [const[false], struct{ovrSizei_: 2, }]] */
  public ovrSizei getBackBufferSize() {
    return ovrSizei.create( accessor.slice( BackBufferSize_offset[mdIdx], BackBufferSize_size[mdIdx] ) );
 }

  /** Setter for native field <code>Multisample</code>: CType[(IntType) 'int', size [fixed false, lnx64 4], [const[false], int]] */
  public ovrRenderAPIConfigHeader setMultisample(int val) {
    accessor.setIntAt(Multisample_offset[mdIdx], val, md.intSizeInBytes());
    return this;
  }

  /** Getter for native field <code>Multisample</code>: CType[(IntType) 'int', size [fixed false, lnx64 4], [const[false], int]] */
  public int getMultisample() {
    return accessor.getIntAt(Multisample_offset[mdIdx], md.intSizeInBytes());
  }
}
