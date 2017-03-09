/* !---- DO NOT EDIT: This file autogenerated by com/jogamp/gluegen/JavaEmitter.java on Sat Oct 10 03:31:13 CEST 2015 ----! */


package com.jogamp.oculusvr;

import java.nio.*;

import com.jogamp.gluegen.runtime.*;
import com.jogamp.common.os.*;
import com.jogamp.common.nio.*;
import jogamp.common.os.MachineDataInfoRuntime;

import com.jogamp.oculusvr.*;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class ovrQuatf {

  StructAccessor accessor;

  private static final int mdIdx = MachineDataInfoRuntime.getStatic().ordinal();
  private final MachineDataInfo md;

  private static final int[] ovrQuatf_size = new int[] { 16 /* ARM_MIPS_32 */, 16 /* X86_32_UNIX */, 16 /* X86_32_MACOS */, 16 /* PPC_32_UNIX */, 16 /* SPARC_32_SUNOS */, 16 /* X86_32_WINDOWS */, 16 /* LP64_UNIX */, 16 /* X86_64_WINDOWS */  };
  private static final int[] x_offset = new int[] { 0 /* ARM_MIPS_32 */, 0 /* X86_32_UNIX */, 0 /* X86_32_MACOS */, 0 /* PPC_32_UNIX */, 0 /* SPARC_32_SUNOS */, 0 /* X86_32_WINDOWS */, 0 /* LP64_UNIX */, 0 /* X86_64_WINDOWS */ };
//private static final int[] x_size = new int[] { 4 /* ARM_MIPS_32 */, 4 /* X86_32_UNIX */, 4 /* X86_32_MACOS */, 4 /* PPC_32_UNIX */, 4 /* SPARC_32_SUNOS */, 4 /* X86_32_WINDOWS */, 4 /* LP64_UNIX */, 4 /* X86_64_WINDOWS */  };
  private static final int[] y_offset = new int[] { 4 /* ARM_MIPS_32 */, 4 /* X86_32_UNIX */, 4 /* X86_32_MACOS */, 4 /* PPC_32_UNIX */, 4 /* SPARC_32_SUNOS */, 4 /* X86_32_WINDOWS */, 4 /* LP64_UNIX */, 4 /* X86_64_WINDOWS */ };
//private static final int[] y_size = new int[] { 4 /* ARM_MIPS_32 */, 4 /* X86_32_UNIX */, 4 /* X86_32_MACOS */, 4 /* PPC_32_UNIX */, 4 /* SPARC_32_SUNOS */, 4 /* X86_32_WINDOWS */, 4 /* LP64_UNIX */, 4 /* X86_64_WINDOWS */  };
  private static final int[] z_offset = new int[] { 8 /* ARM_MIPS_32 */, 8 /* X86_32_UNIX */, 8 /* X86_32_MACOS */, 8 /* PPC_32_UNIX */, 8 /* SPARC_32_SUNOS */, 8 /* X86_32_WINDOWS */, 8 /* LP64_UNIX */, 8 /* X86_64_WINDOWS */ };
//private static final int[] z_size = new int[] { 4 /* ARM_MIPS_32 */, 4 /* X86_32_UNIX */, 4 /* X86_32_MACOS */, 4 /* PPC_32_UNIX */, 4 /* SPARC_32_SUNOS */, 4 /* X86_32_WINDOWS */, 4 /* LP64_UNIX */, 4 /* X86_64_WINDOWS */  };
  private static final int[] w_offset = new int[] { 12 /* ARM_MIPS_32 */, 12 /* X86_32_UNIX */, 12 /* X86_32_MACOS */, 12 /* PPC_32_UNIX */, 12 /* SPARC_32_SUNOS */, 12 /* X86_32_WINDOWS */, 12 /* LP64_UNIX */, 12 /* X86_64_WINDOWS */ };
//private static final int[] w_size = new int[] { 4 /* ARM_MIPS_32 */, 4 /* X86_32_UNIX */, 4 /* X86_32_MACOS */, 4 /* PPC_32_UNIX */, 4 /* SPARC_32_SUNOS */, 4 /* X86_32_WINDOWS */, 4 /* LP64_UNIX */, 4 /* X86_64_WINDOWS */  };

  public static int size() {
    return ovrQuatf_size[mdIdx];
  }

  public static ovrQuatf create() {
    return create(Buffers.newDirectByteBuffer(size()));
  }

  public static ovrQuatf create(java.nio.ByteBuffer buf) {
      return new ovrQuatf(buf);
  }

  ovrQuatf(java.nio.ByteBuffer buf) {
    md = MachineDataInfo.StaticConfig.values()[mdIdx].md;
    accessor = new StructAccessor(buf);
  }

  public java.nio.ByteBuffer getBuffer() {
    return accessor.getBuffer();
  }

  /** Setter for native field <code>x</code>: CType[(FloatType) 'float', size [fixed true, lnx64 4], [const[false], float]] */
  public ovrQuatf setX(float val) {
    accessor.setFloatAt(x_offset[mdIdx], val);
    return this;
  }

  /** Getter for native field <code>x</code>: CType[(FloatType) 'float', size [fixed true, lnx64 4], [const[false], float]] */
  public float getX() {
    return accessor.getFloatAt(x_offset[mdIdx]);
  }

  /** Setter for native field <code>y</code>: CType[(FloatType) 'float', size [fixed true, lnx64 4], [const[false], float]] */
  public ovrQuatf setY(float val) {
    accessor.setFloatAt(y_offset[mdIdx], val);
    return this;
  }

  /** Getter for native field <code>y</code>: CType[(FloatType) 'float', size [fixed true, lnx64 4], [const[false], float]] */
  public float getY() {
    return accessor.getFloatAt(y_offset[mdIdx]);
  }

  /** Setter for native field <code>z</code>: CType[(FloatType) 'float', size [fixed true, lnx64 4], [const[false], float]] */
  public ovrQuatf setZ(float val) {
    accessor.setFloatAt(z_offset[mdIdx], val);
    return this;
  }

  /** Getter for native field <code>z</code>: CType[(FloatType) 'float', size [fixed true, lnx64 4], [const[false], float]] */
  public float getZ() {
    return accessor.getFloatAt(z_offset[mdIdx]);
  }

  /** Setter for native field <code>w</code>: CType[(FloatType) 'float', size [fixed true, lnx64 4], [const[false], float]] */
  public ovrQuatf setW(float val) {
    accessor.setFloatAt(w_offset[mdIdx], val);
    return this;
  }

  /** Getter for native field <code>w</code>: CType[(FloatType) 'float', size [fixed true, lnx64 4], [const[false], float]] */
  public float getW() {
    return accessor.getFloatAt(w_offset[mdIdx]);
  }
}